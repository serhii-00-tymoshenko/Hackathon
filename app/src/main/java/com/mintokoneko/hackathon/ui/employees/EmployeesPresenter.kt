package com.mintokoneko.hackathon.ui.employees

import com.mintokoneko.hackathon.entities.Employee

class EmployeesPresenter(
    private val view: EmployeesContractor.View,
    private val model: EmployeesContractor.Model
) : EmployeesContractor.Presenter {
    override fun onItemClick(employee: Employee) {
        view.navigateToDetails(employee)
    }

}