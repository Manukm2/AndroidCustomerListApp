package com.example.customerlistapp.customers.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customerlistapp.R
import com.example.customerlistapp.customers.model.Customer
import com.example.customerlistapp.customers.ui.adeptor.CustomerListAdeptor
import com.example.customerlistapp.customers.viewmodel.CustomerViewModel
import com.example.customerlistapp.databinding.FragmentCustomerListBinding

class CustomerListFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerListFragment()
    }

    private lateinit var binding: FragmentCustomerListBinding
    private lateinit var viewModel: CustomerViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        Log.d("","------------------CustomerListFragment.onCreateView()----------------------------")
        binding = FragmentCustomerListBinding.inflate(inflater,container,false)
        return binding.root     /* Our Customer list fragment is connected layout which as the recycler view */
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("","------------------CustomerListFragment.onActivityCreated()----------------------------")
        viewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)
       viewModel.loadCustomerList().observe(viewLifecycleOwner, fun(customer : List<Customer>){
           Log.d("","------------------${customer}----------------------------")
           val adapter = CustomerListAdeptor(customer)
           binding.customerListRecyclerview.adapter = adapter
           binding.customerListRecyclerview.layoutManager = LinearLayoutManager(context)
       })
    }
}