package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class inicio_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_admin)
        //botones
        val retunra: Button = findViewById(R.id.button3)
        val alogin: Button = findViewById(R.id.button)
        //datos de login
        val acorreo: EditText = findViewById(R.id.AdminEmail)
        val aconraseña: EditText = findViewById(R.id.AdminPassword)
        //conexion a la base de datps
        val db = FirebaseFirestore.getInstance()

        //Si el administrador presiona salir regresa a pantalla principal
        retunra.setOnClickListener{
            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }

        //Si el administrador presiona INGRESAR ingresa a pantalla sesion_admin
        alogin.setOnClickListener{
            if (acorreo.text.isNotEmpty() && aconraseña.text.isNotEmpty()){
                db.collection("Usuarios").whereEqualTo("email",acorreo).addSnapshotListener()
            }else{
                Toast.makeText(this, "se deben rellenar todos los elementos", Toast.LENGTH_SHORT).show()
            }
            val intent: Intent = Intent(this, sesion_admin:: class.java)
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