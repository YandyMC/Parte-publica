package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class exito_vercita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exito_vercita)

        //Boton aceptar
        val btn2: Button = findViewById(R.id.button7)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, sesion_medico:: class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla principal sesion medico
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_medico::class.java))
        finish()
    }
}