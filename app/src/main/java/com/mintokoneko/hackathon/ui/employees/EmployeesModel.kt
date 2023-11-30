package com.mintokoneko.hackathon.ui.employees

import com.mintokoneko.hackathon.R
import com.mintokoneko.hackathon.entities.Credentials
import com.mintokoneko.hackathon.entities.Employee

class EmployeesModel : EmployeesContractor.Model {
    private lateinit var employee: Employee

    override fun getEmployees(): List<Employee> {
        return listOf(
            Employee("Sehii", id = 0),
            Employee("Dmytro", position = "Admin", trustLevel = R.color.green, id = 1),
            Employee("Oleksand", photo = R.drawable.ic_launcher_foreground, trustLevel = R.color.red, id = 2)
        )
    }

    override fun setEmployee(employee: Employee) {
        this.employee = employee
    }

    override fun getEmployee(): Employee = employee
}