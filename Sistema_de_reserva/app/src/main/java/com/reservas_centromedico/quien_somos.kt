package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class quien_somos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_somos)

        //Boton volver
        val btn: Button = findViewById(R.id.button21)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, main_screen::class.java)
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