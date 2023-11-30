package com.mintokoneko.hackathon.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mintokoneko.hackathon.ui.main.MainActivity
import com.mintokoneko.hackathon.databinding.ActivityLoginBinding
import com.mintokoneko.hackathon.entities.Credentials

class LoginActivity : AppCompatActivity(), LoginContractor.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var model: LoginModel
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = LoginModel()
        presenter = LoginPresenter(this, model)

        binding.apply {
            binding.navigateToMain.setOnClickListener {
                val login = login.editText?.text.toString()
                val password = password.editText?.text.toString()

                if (login.isNotEmpty() && password.isNotEmpty()) {
                    presenter.onLoginClick(login, password)
                } else {
                    Toast.makeText(this@LoginActivity, "Wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun navigateToMain(credentials: Credentials) {
        val mainIntent = Intent(this@LoginActivity, MainActivity::class.java)
        mainIntent.putExtra(MainActivity.TAG, credentials)
        startActivity(mainIntent)
    }
}