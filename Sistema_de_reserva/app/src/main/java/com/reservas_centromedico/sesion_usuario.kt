package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class sesion_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion_usuario)
        //Regresar a pantalla principal luego de presionar salir
        val btn: Button = findViewById(R.id.button11 )
        btn.setOnClickListener{
            //Redirigir a la pantalla de inicio sesion usuario
            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
        //Ingresar a modificar datos
        val btn2: Button = findViewById(R.id.button9 )
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, mod_usuario:: class.java)
            startActivity(intent)
            finish()
        }
        //Ingresar a nueva cita
        val btn3: Button = findViewById(R.id.button10)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this, user_nuevacita:: class.java)
            startActivity(intent)
            finish()
        }
        //Cancelar cita1
        val btn4: Button = findViewById(R.id.button12)
        btn4.setOnClickListener{
            val intent: Intent = Intent(this, cancel_cita:: class.java)
            startActivity(intent)
            finish()
        }
        //Ingresar a nueva cita
        val btn5: Button = findViewById(R.id.button14)
        btn5.setOnClickListener{
            val intent: Intent = Intent(this, cancel_cita:: class.java)
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