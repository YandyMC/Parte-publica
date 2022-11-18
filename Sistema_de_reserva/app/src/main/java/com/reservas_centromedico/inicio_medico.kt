package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class inicio_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_medico)
        //botones
        val returnr: Button = findViewById(R.id.button3)
        val mlogin: Button = findViewById(R.id.button)
        //dato de login
        val mcorreo: EditText = findViewById(R.id.MedicEmail)
        val mconraseña: EditText = findViewById(R.id.MedicPassword)
        //conexion a la base de datos



        //Si el MEDICO presiona salir regresa a pantalla principal
        returnr.setOnClickListener{
            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }


        //Si el MEDICO presiona ingresar, pantalla de sesion medico
        mlogin.setOnClickListener{
            if (mcorreo.text.isNotEmpty() && mconraseña.text.isNotEmpty()){
                //db.collection("Usuarios").whereEqualTo("email",ucorreo).addSnapshotListener()
            }else{
                Toast.makeText(this, "se deben rellenar todos los elementos", Toast.LENGTH_SHORT).show()
            }

            val intent: Intent = Intent(this, sesion_medico:: class.java)
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