package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class user_selecmedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_selecmedico)

        //Permitir el cambio de interfaz a usuario mediante boton
        val btn: Button = findViewById(R.id.button25)
        btn.setOnClickListener{
            //Redirigir a la pantalla de nuevacita
            val intent: Intent = Intent(this, user_nuevacita:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton selec medico1
        val btn2: Button = findViewById(R.id.button27)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, user_checkmedico:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton selec medico2
        val btn3: Button = findViewById(R.id.button29)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this, user_checkmedico:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton selec medico3
        val btn4: Button = findViewById(R.id.button30)
        btn4.setOnClickListener{
            val intent: Intent = Intent(this, user_checkmedico:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla nuevacita
    override fun onBackPressed() {
        startActivity(Intent(this,user_nuevacita::class.java))
        finish()
    }
}