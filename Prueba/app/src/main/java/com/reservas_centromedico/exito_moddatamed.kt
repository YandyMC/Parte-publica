package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class exito_moddatamed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exito_moddatamed)

        //Boton aceptar
        val btn: Button = findViewById(R.id.button7)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, sesion_medico:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla sesion medico
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_medico::class.java))
        finish()
    }
}