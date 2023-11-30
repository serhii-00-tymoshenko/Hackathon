package com.mintokoneko.hackathon.ui.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mintokoneko.hackathon.ui.main.MainActivity
import com.mintokoneko.hackathon.databinding.ActivityRegistrationBinding
import com.mintokoneko.hackathon.entities.Credentials
import com.mintokoneko.hackathon.ui.login.LoginActivity

class RegistrationActivity : AppCompatActivity(), RegistrationContractor.View {
    private lateinit var model: RegistrationModel
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = RegistrationModel()
        presenter = RegistrationPresenter(this, model)

        binding.apply {
            registrationNavigateToLogin.setOnClickListener {
                presenter.onLoginClick()
            }

            signUp.setOnClickListener {
                val login = registrationLogin.editText?.text.toString()
                val password = registrationPassword.editText?.text.toString()

                if (login.isNotEmpty() && password.isNotEmpty()) {
                    presenter.onRegisterClick(login, password)
                } else {
                    Toast.makeText(this@RegistrationActivity, "Wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun navigateToLogin() {
        val loginIntent = Intent(this@RegistrationActivity, LoginActivity::class.java)
        startActivity(loginIntent)
    }


    override fun navigateToMain(credentials: Credentials) {
        val mainIntent = Intent(this@RegistrationActivity, MainActivity::class.java)
        mainIntent.putExtra(MainActivity.TAG, credentials)
        startActivity(mainIntent)
        finish()
    }
}