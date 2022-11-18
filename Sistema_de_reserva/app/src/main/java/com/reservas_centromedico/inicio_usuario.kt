package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class inicio_usuario : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_usuario)
        //botones a usar
        val register: Button = findViewById(R.id.button2)
        val return1: Button = findViewById(R.id.button3)
        val login: Button = findViewById(R.id.button)
        // variables de ingreso
        val ucorreo: EditText = findViewById(R.id.UserEmail)
        val ucontraseña: EditText = findViewById(R.id.UserPassword)
        //inicializar conexion a la base de datos
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()


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
            val intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }

        //Si el usuario inicia sesion, INGRESAR al acceso restringido usuario
        login.setOnClickListener {
            val email = ucorreo.text.toString()
            val password= ucontraseña.text.toString()
            if (email.isEmpty() || password.isEmpty()){
                if(email.isEmpty()){
                    Toast.makeText(this, "el email esta vacio", Toast.LENGTH_SHORT).show()
                }
                if(password.isEmpty()){
                    Toast.makeText(this, "no se ha ingresado una contraseña", Toast.LENGTH_SHORT).show()
                }
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this, sesion_usuario:: class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "hay problemas encontrando el usuario", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }


    //Asignar que el boton atras regrese a la pantalla principal
    override fun onBackPressed() {
        startActivity(Intent(this,main_screen::class.java))
        finish()
    }
}