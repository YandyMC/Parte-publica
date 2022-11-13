package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Lreg_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lreg_medico)

        //Permitir el cambio de interfaz a usuario mediante boton CANCELAR
        val btn: Button = findViewById(R.id.button8)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, sesion_admin:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton REGISTRAR
        val btn2: Button = findViewById(R.id.button7)
        btn2.setOnClickListener{

            val intent: Intent = Intent(this, exito_regmedico:: class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla sesion admin
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_admin::class.java))
        finish()
    }
}