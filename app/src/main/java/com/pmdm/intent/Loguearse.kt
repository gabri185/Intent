package com.pmdm.intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Loguearse : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loguearse)

        val mEmail: EditText = findViewById(R.id.emailAccess)
        val mPassword: EditText = findViewById(R.id.passwordAccess)
        val rLogin: Button = findViewById(R.id.bLogin)

        fun login() {
            var email: String = mEmail.getText().toString()
            var password: String = mPassword.getText().toString()

            if (!email.isEmpty() && !password.isEmpty()) {
                if (password.length >= 6) {
                } else {
                    Toast.makeText(this, "Email o Contraseña incorrectos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        rLogin.setOnClickListener() {
            login()
        }
    }
}