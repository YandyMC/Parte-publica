package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class medico_vercita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medico_vercita)

        //Boton finalizar cita
        val btn: Button = findViewById(R.id.button33)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, exito_vercita:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton volver
        val btn2: Button = findViewById(R.id.button34)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, sesion_medico:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla principal
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_medico::class.java))
        finish()
    }
}