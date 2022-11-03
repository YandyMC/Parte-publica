package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class reg_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_usuario)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Permitir el cambio de interfaz a usuario mediante boton
        val btn: Button = findViewById(R.id.button7 )
        btn.setOnClickListener{

            val intent: Intent = Intent(this, reg_exito:: class.java)
            startActivity(intent)
            finish()
        }
        val btn2: Button = findViewById(R.id.button8 )
        btn2.setOnClickListener{

            val intent: Intent = Intent(this, inicio_usuario:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla inicio sesion usuario
    override fun onBackPressed() {
        startActivity(Intent(this,inicio_usuario::class.java))
        finish()
    }
}