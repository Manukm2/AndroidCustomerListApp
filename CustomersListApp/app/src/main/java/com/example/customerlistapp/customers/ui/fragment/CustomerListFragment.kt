package com.example.customerlistapp.customers.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customerlistapp.R
import com.example.customerlistapp.customers.viewmodel.CustomerViewModel
import com.example.customerlistapp.databinding.FragmentCustomerListBinding

class CustomerListFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerListFragment()
    }

    private lateinit var binding: FragmentCustomerListBinding
    private lateinit var viewModel: CustomerViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentCustomerListBinding.inflate(inflater,container,false)
        return binding.root     /* Our Customer list fragment is connected layout which as the recycler view */
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}