package com.example.customerlistapp.customers.service

import com.example.customerlistapp.customers.model.Customer
import retrofit2.Call
import retrofit2.http.GET

interface CustomerService {

    @GET("customers.json")
    fun customList() : Call<List<Customer>>

}