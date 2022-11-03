package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class user_nuevacita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_nuevacita)

        //Regresar a pantalla principal luego de presionar cancelar
        val btn: Button = findViewById(R.id.button24)
        btn.setOnClickListener{
            //Redirigir a la pantalla de sesion usuario
            val intent: Intent = Intent(this, sesion_usuario:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton Agendar cita
        val btn2: Button = findViewById(R.id.button22)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, exito_usernewcita:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton Seleccionar medico
        val btn3: Button = findViewById(R.id.button23)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this, user_selecmedico:: class.java)
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