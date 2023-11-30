package com.mintokoneko.hackathon.ui.employees

import com.mintokoneko.hackathon.entities.Credentials
import com.mintokoneko.hackathon.entities.Employee

interface EmployeesContractor {
    interface View {
        fun navigateToDetails(employee: Employee)
    }
    interface Model {
        fun getEmployees(): List<Employee>
        fun setEmployee(employee: Employee)
        fun getEmployee(): Employee
    }
    interface Presenter {
        fun onItemClick(employee: Employee)
    }
}