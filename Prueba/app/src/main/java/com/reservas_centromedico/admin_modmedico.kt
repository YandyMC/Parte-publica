package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class admin_modmedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_modmedico)

        //Boton cancelar
        val btn: Button = findViewById(R.id.button28)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, sesion_admin:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton salir
        val btn2: Button = findViewById(R.id.button31)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton buscar
        val btn3: Button = findViewById(R.id.button26)
        btn3.setOnClickListener{
            val intent: Intent = Intent(this, mod_medico:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla login admin
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_admin::class.java))
        finish()
    }
}