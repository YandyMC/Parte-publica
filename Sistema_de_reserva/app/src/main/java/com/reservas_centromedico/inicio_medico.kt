package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_medico)

        //Si el MEDICO presiona salir regresa a pantalla principal
        val btn: Button = findViewById(R.id.button3)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
        //Si el MEDICO presiona ingresar, pantalla de sesion medico
        val btn2: Button = findViewById(R.id.button)
        btn2.setOnClickListener{

            val intent: Intent = Intent(this, sesion_medico:: class.java)
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