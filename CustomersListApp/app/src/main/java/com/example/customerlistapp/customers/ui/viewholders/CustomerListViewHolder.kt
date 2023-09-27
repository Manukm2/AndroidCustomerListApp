package com.example.customerlistapp.customers.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.customerlistapp.R
import com.example.customerlistapp.customers.model.Customer
import com.example.customerlistapp.databinding.ItemCustomerListBinding

class CustomerListViewHolder(private val binding : ItemCustomerListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(customer: Customer){
        /*recyclerview will call to help the view binder to help this viewholder set the values on the item layout  */
        binding.customerNameTextView.text = binding.root.context.getString(R.string.customer_name,customer.firstName, customer.lastname)
        binding.customerNameTextView.text = customer.userName
    }

}