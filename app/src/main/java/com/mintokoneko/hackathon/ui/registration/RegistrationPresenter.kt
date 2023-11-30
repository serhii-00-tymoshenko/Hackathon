package com.mintokoneko.hackathon.ui.registration

class RegistrationPresenter(
    private val view: RegistrationContractor.View,
    private val model: RegistrationContractor.Model
) : RegistrationContractor.Presenter {
    override fun onLoginClick() {
        view.navigateToLogin()
    }

    override fun onRegisterClick(login: String, password: String) {
        // Типу записав в sharedPreferences
        model.setCredentials(login, password)
        // Типу взяв
        val credentials = model.getCredentials()
        view.navigateToMain(credentials)
    }
}