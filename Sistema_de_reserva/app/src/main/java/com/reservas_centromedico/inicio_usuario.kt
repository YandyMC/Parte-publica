package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class inicio_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_usuario)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Permitir el cambio de interfaz a usuario mediante boton
        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, reg_usuario:: class.java)
            startActivity(intent)
            finish()
        }
        //Si el usuario presiona salir regresa a pantalla principal
        val btn2: Button = findViewById(R.id.button3)
        btn2.setOnClickListener{

            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
        //Si el usuario inicia sesion, INGRESAR al acceso restringido usuario
        val btn3: Button = findViewById(R.id.button)
        btn3.setOnClickListener{

            val intent: Intent = Intent(this, sesion_usuario:: class.java)
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