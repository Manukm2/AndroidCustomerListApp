package com.example.customerlistapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.customerlistapp.customers.model.Customer
import com.example.customerlistapp.customers.service.CustomerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//repository will helps us to communicate with the network and this will be our bottom most layer of the MVVM pattern that we have followed

private const val BASE_URL = "https://androidbasics-e48d1.firebaseapp.com/"
class NetworkRepository {

    private lateinit var customerService : CustomerService // We need private member variable to hold the CustomerService
    private val customerList = MutableLiveData<List<Customer>>() /*List of mutable live data which means that it will allow us to set the value
                    once we have fetched it over the network*/
    init {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)     ///We are adding base URL
        .addConverterFactory(GsonConverterFactory.create())   //We are adding the convertorfactory which comes from Gson that we are using to parse the Json data.
        .build()
        customerService = retrofit.create(CustomerService::class.java) /*We've defined a network repository and it has been linked to retrofit service to help it
        fetch the data from the particular base URL and the relative path */
    }

    fun fetchCustomerList(){
        /*This method will help us to fetch the Customer List data and this will be invoked by the viewmodel at the start to help the
        repository start fetching this data   */
        customerService.customList().enqueue(object : Callback<List<Customer>>{
            override fun onResponse(call: Call<List<Customer>>, response: Response<List<Customer>>) {
                if(response.isSuccessful){
                        response.body()?.let {
                            customerList.value = response.body()
                        }
                }else{
                    Log.d("NetworkRepo", "Response unsuccessful")
                }
            }

            override fun onFailure(call: Call<List<Customer>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun customerList() : LiveData<List<Customer>> {
        /*Final thing we need is to expose this mutable live data*/
        return customerList
    }

}