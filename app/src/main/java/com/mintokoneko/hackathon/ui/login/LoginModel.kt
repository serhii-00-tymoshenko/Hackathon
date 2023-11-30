package com.mintokoneko.hackathon.ui.login

import com.mintokoneko.hackathon.entities.Credentials

class LoginModel : LoginContractor.Model {
    companion object {
        private lateinit var credentials: Credentials
    }
    override fun setCredentials(login: String, password: String) {
        credentials = Credentials(login, password)
    }

    override fun getCredentials() = credentials
}