package com.example.customerlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.customerlistapp.customers.ui.fragment.CustomerListFragment
import com.example.customerlistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("","------------------MainActivity----------------------------")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = CustomerListFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commitNowAllowingStateLoss()
        Log.d("","------------------MainActivity----------------------------")
    }
}