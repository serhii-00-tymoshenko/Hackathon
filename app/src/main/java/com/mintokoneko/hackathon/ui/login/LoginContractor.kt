package com.mintokoneko.hackathon.ui.login

import com.mintokoneko.hackathon.entities.Credentials

interface LoginContractor {
    interface View {
        fun navigateToMain(credentials: Credentials)
    }
    interface Model {
        fun setCredentials(login: String, password: String)
        fun getCredentials(): Credentials
    }
    interface Presenter {
        fun onLoginClick(login: String, password: String)
    }
}