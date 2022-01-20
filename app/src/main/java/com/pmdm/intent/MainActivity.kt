package com.pmdm.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val TAG = "RealTime"
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mLogin: Button = findViewById(R.id.bLogin)
        val mRegister: Button = findViewById(R.id.bRegister)

        mLogin.setOnClickListener() {
            Loguearse()
        }
        mRegister.setOnClickListener() {
            Registrarse()
        }

        /*
        database = Firebase.database("https://agarimo-241c2-default-rtdb.firebaseio.com/").reference

        //boton para escribir
        val miBoton: Button = findViewById(R.id.miBoton)
        miBoton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                writeNewData("AA02", "paco", 0.205, 7.245)
            }
        })

        //texto para recoger
        val miTexto: TextView = findViewById(R.id.miTexto)

        //leer los datos cuando cambie
        val datoListener = object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dato = dataSnapshot.getValue()
                Log.d( TAG, "cambio" + dato.toString())
                miTexto.text = dato.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.d(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.addValueEventListener(datoListener)

*/
    }
/*
    fun  writeNewData(userId: String, nombre:String, latitud: Double, longitud: Double){

        Log.d(TAG, "Escribiendo datos")
        val user = Profesionales(nombre, latitud, longitud)

        database.child("Profesionales").child(userId).setValue(user)
    }
*/
    private fun Registrarse() {
        val intent = Intent(this, Registrarse::class.java)
        startActivity(intent)
    }
    private fun Loguearse() {
        val intent2 = Intent(this, Loguearse::class.java)
        startActivity(intent2)
    }

}