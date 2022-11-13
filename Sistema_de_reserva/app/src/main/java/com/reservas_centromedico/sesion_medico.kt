package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class sesion_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion_medico)

        //Regresar a pantalla principal luego de presionar salir
        val btn: Button = findViewById(R.id.button11 )
        btn.setOnClickListener{
            //Redirigir a la pantalla principal
            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea boton modificar datos medico
        val btn2: Button = findViewById(R.id.button9)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, mod_datamedico:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea boton ir a cita1
        val btn3: Button = findViewById(R.id.button12)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this, medico_vercita:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea boton ir a cita2
        val btn4: Button = findViewById(R.id.button14)
        btn4.setOnClickListener{
            val intent: Intent = Intent(this, medico_vercita2:: class.java)
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