package com.example.customerlistapp.customers.model

import com.google.gson.annotations.SerializedName

//This is the data class which means that this class will exclusively be used as the Entity or POJO to hold the customers after we pass them from the Json response
// so in data class we only need the initial constructors where we can define all the member variables
//This is the data class that we will use to store the data once it has been passed from  the Json
data class Customer (
    @SerializedName("UserName") val userName : String,
    @SerializedName("FirstName") val firstName : String,
    @SerializedName("MiddleName") val middleName : String,
    @SerializedName("LastName") val lastname : String
)