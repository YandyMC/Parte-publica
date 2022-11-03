package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class user_checkmedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_checkmedico)

        //Boton aceptar
        val btn2: Button = findViewById(R.id.button7)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, user_nuevacita:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton aceptar regresa a la pantalla nuevacita
    override fun onBackPressed() {
        startActivity(Intent(this,user_nuevacita::class.java))
        finish()
    }
}