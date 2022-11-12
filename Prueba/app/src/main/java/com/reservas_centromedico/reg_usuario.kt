package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class reg_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_usuario)

        //conexion a la base de datos
        val db = FirebaseFirestore.getInstance()

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Permitir el cambio de interfaz a usuario mediante boton
        val register: Button = findViewById(R.id.button7 )
        register.setOnClickListener{

            val intent: Intent = Intent(this, reg_exito:: class.java)
            startActivity(intent)
            finish()
        }
        val cancel: Button = findViewById(R.id.button8 )
        cancel.setOnClickListener{

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