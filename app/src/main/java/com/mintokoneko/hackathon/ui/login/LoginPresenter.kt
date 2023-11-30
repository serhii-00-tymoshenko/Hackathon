package com.mintokoneko.hackathon.ui.login

import com.mintokoneko.hackathon.entities.Credentials

class LoginPresenter(
    private val view: LoginContractor.View,
    private val model: LoginContractor.Model
) : LoginContractor.Presenter {
    override fun onLoginClick(login: String, password: String) {
        // типу поклав в sharedPreferences
        model.setCredentials(login, password)
        // типу взяв
        val credentials = model.getCredentials()
        view.navigateToMain(credentials)
    }
}