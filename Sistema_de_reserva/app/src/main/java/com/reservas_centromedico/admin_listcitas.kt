package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class admin_listcitas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_listcitas)

        //Boton VOLVER
        val btn: Button = findViewById(R.id.button32)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, sesion_admin:: class.java)
            startActivity(intent)
            finish()
        }

        //Boton SALIR
        val btn2: Button = findViewById(R.id.button25)
        btn2.setOnClickListener{

            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla principal administrador
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_admin::class.java))
        finish()
    }
}