package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class amod_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amod_usuario)

        //Boton CANCELAR
        val btn: Button = findViewById(R.id.button8)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, sesion_admin:: class.java)
            startActivity(intent)
            finish()
        }

        //Boton GUARDAR
        val btn2: Button = findViewById(R.id.button7)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, aexito_modusuario:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla login admin
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_admin::class.java))
        finish()
    }
}