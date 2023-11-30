package com.mintokoneko.hackathon.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mintokoneko.hackathon.R
import com.mintokoneko.hackathon.databinding.ActivityMainBinding
import com.mintokoneko.hackathon.entities.Credentials
import com.mintokoneko.hackathon.entities.Employee
import com.mintokoneko.hackathon.ui.employee_details.EmployeeDetailsFragment

class MainActivity : AppCompatActivity(), MainContractor.View {
    private lateinit var binding: ActivityMainBinding
    companion object {
        const val TAG = "MainActivity"
    }

    private val credentials by lazy {
        val credentials = intent.extras?.getParcelable<Credentials>(TAG)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun navigateToDetails(employee: Employee) {
        val details = EmployeeDetailsFragment()
        val bundle = Bundle()
        bundle.putParcelable(TAG, employee)
        details.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .replace(binding.root.id, details)
            .commit()
    }
}