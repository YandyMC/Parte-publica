package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class mod_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mod_usuario)

        //Regresar a pantalla principal luego de presionar cancelar
        val btn: Button = findViewById(R.id.button8 )
        btn.setOnClickListener{
            val intent: Intent = Intent(this, sesion_usuario:: class.java)
            startActivity(intent)
            finish()
        }
        //Modificar datos
        val btn2: Button = findViewById(R.id.button7 )
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, exito_modusuario:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla principal
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_usuario::class.java))
        finish()
    }
}