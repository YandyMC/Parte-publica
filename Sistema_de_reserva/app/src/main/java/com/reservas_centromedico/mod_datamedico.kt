package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class mod_datamedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mod_datamedico)

        //Boton cancelar
        val btn3: Button = findViewById(R.id.button8)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this, sesion_medico:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton actualizar
        val btn4: Button = findViewById(R.id.button7)
        btn4.setOnClickListener{
            val intent: Intent = Intent(this, exito_moddatamed:: class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla sesion medico
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_medico::class.java))
        finish()
    }
}