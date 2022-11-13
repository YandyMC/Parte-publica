package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class exito_regmedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exito_regmedico)

        //Permitir el cambio de interfaz a usuario mediante boton ACEPTAR
        val btn: Button = findViewById(R.id.button7 )
        btn.setOnClickListener{
            //Redirigir a la pantalla de inicio sesion usuario
            val intent: Intent = Intent(this, sesion_admin:: class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla principal
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_admin::class.java))
        finish()
    }
}