package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class reg_exito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_exito)

        //Permitir el cambio de interfaz a usuario mediante boton
        val btn: Button = findViewById(R.id.button7 )
        btn.setOnClickListener{
            //Redirigir a la pantalla de inicio sesion usuario
            val intent: Intent = Intent(this, inicio_usuario:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla principal
    override fun onBackPressed() {
        startActivity(Intent(this,main_screen::class.java))
        finish()
    }
}