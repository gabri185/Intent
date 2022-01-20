package com.pmdm.intent

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Registrarse : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrarse)


        val Txtemail: EditText = findViewById(R.id.Txtemail)
        val Txtcon: EditText = findViewById(R.id.Txtcon)
        val boton: Button = findViewById(R.id.boton)
        var progress = ProgressDialog(this)

        val firebaseauth: FirebaseAuth = FirebaseAuth.getInstance();




        fun registrarUsuario() {
            //Conseguimos el email y la contraseña de las cajas de texto
            val email: String = Txtemail.text.toString()
            val contraseña: String = Txtcon.text.toString()

            //Comproba,os que las cajas de texto no estan vacias
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Tienes que ingresar tu email", Toast.LENGTH_LONG).show();
            }
            if (TextUtils.isEmpty(contraseña)) {
                Toast.makeText(this, "Tienes que ingresar tu contraseña", Toast.LENGTH_LONG).show();
            }

            progress.setMessage("Realizando registrp en linea")
            progress.show()


            firebaseauth.createUserWithEmailAndPassword(email, contraseña)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(
                            this, "Se ha registrado el usuario con el email" + Txtemail.text,
                            Toast.LENGTH_LONG
                        ).show();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "No se pudo registrar el usuario", Toast.LENGTH_LONG)
                            .show();
                    }
                    progress.dismiss()
                }


        }
        boton.setOnClickListener() {
            registrarUsuario()
        }
    }

    }
