package com.example.customerlistapp.customers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.customerlistapp.customers.model.Customer
import com.example.customerlistapp.repository.NetworkRepository

//This is the intermediate layer in our MVVM pattern
class CustomerViewModel : ViewModel() {

    private val repository = NetworkRepository()

    fun loadCustomerList() : LiveData<List<Customer>>{
        /*This method is called from the UI to start loading the Customer List data.  */
        Log.d("","------------------CustomerViewModel.loadCustomerList()----------------------------")
        repository.fetchCustomerList()
        return repository.customerList()
    }

}