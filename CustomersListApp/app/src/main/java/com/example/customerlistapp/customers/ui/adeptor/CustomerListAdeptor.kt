package com.example.customerlistapp.customers.ui.adeptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customerlistapp.customers.model.Customer
import com.example.customerlistapp.customers.ui.viewholders.CustomerListViewHolder
import com.example.customerlistapp.databinding.ItemCustomerListBinding

class CustomerListAdeptor(private val customers : List<Customer>) : RecyclerView.Adapter<CustomerListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCustomerListBinding.inflate(inflater,parent,false)
        return CustomerListViewHolder(binding)
    }

    override fun getItemCount(): Int { // Size of the customers
        return customers.size
    }

    override fun onBindViewHolder(holder: CustomerListViewHolder, position: Int) {
        holder.bind(customers[position]) /* We are telling the viewholder that you need to show the data correspounding to this position object which is at this
                                        position in the list of customers */
    }

}