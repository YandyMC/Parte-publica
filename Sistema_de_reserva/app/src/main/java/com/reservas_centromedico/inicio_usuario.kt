package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.FirebaseFirestore

class inicio_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_usuario)
        //botones a usar
        val register: Button = findViewById(R.id.button2)
        val return1: Button = findViewById(R.id.button3)
        val login: Button = findViewById(R.id.button)
        // variables de ingreso
        val ucorreo: EditText = findViewById(R.id.UserEmail)
        val uconraseña: EditText = findViewById(R.id.UserPassword)
        //conectar base de datos
        val db = FirebaseFirestore.getInstance()

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Permitir el cambio de interfaz a usuario mediante boton

        //redirigir a la interfaz de registro
        register.setOnClickListener{
            val intent: Intent = Intent(this, reg_usuario:: class.java)
            startActivity(intent)
            finish()
        }
        //Si el usuario presiona salir regresa a pantalla principal
        return1.setOnClickListener{
            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }

        //Si el usuario inicia sesion, INGRESAR al acceso restringido usuario
        login.setOnClickListener{
            if (ucorreo.text.isNotEmpty() && uconraseña.text.isNotEmpty()){
                db.collection("Usuarios").whereEqualTo("email",ucorreo).addSnapshotListener()
            }else{
                Toast.makeText(this, "se deben rellenar todos los elementos", Toast.LENGTH_SHORT).show()
            }
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