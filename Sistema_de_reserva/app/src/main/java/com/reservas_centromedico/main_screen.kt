package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class main_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Habilitar cambio de ventana al presionar botones
        val btn: Button = findViewById(R.id.button5)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, inicio_usuario::class.java)
            startActivity(intent)
            finish()
        }
        //Boton administrador
        val btn2: Button = findViewById(R.id.button4)
        btn2.setOnClickListener {

            val intent: Intent = Intent(this, inicio_admin::class.java)
            startActivity(intent)
            finish()
        }
        //Boton medico
        val btn3: Button = findViewById(R.id.button6)
        btn3.setOnClickListener {

            val intent: Intent = Intent(this, inicio_medico::class.java)
            startActivity(intent)
            finish()
        }
        //Boton quienes somos
        val btn4: Button = findViewById(R.id.button21)
        btn4.setOnClickListener {

            val intent: Intent = Intent(this, quien_somos::class.java)
            startActivity(intent)
            finish()
        }
    }
}