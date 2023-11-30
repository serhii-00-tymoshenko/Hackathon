package com.mintokoneko.hackathon.ui.registration

import com.mintokoneko.hackathon.entities.Credentials

interface RegistrationContractor {
    interface View {
        fun navigateToLogin()
        fun navigateToMain(credentials: Credentials)
    }
    interface Model {
        fun setCredentials(login: String, password: String)
        fun getCredentials(): Credentials
    }
    interface Presenter {
        fun onLoginClick()
        fun onRegisterClick(login: String, password: String)
    }
}