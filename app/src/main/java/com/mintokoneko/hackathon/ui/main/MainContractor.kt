package com.mintokoneko.hackathon.ui.main

import com.mintokoneko.hackathon.entities.Credentials
import com.mintokoneko.hackathon.entities.Employee

interface MainContractor {
    interface View {
        fun navigateToDetails(employee: Employee)
    }
    interface Presenter {
        fun navigateToDetails()
    }
}