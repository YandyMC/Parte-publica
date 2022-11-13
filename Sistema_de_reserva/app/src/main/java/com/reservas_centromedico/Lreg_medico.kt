package com.reservas_centromedico

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Lreg_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lreg_medico)
        //botons
        val btn: Button = findViewById(R.id.button8)
        val btn2: Button = findViewById(R.id.button7)
        //datos a ingresar
        val ci: EditText = findViewById(R.id.MedicCI)
        val nombre: EditText = findViewById(R.id.medicname)
        val apellido: EditText = findViewById(R.id.mediclastname)
        val correo: EditText = findViewById(R.id.medicemail)
        val fecha: EditText = findViewById(R.id.medicdate)
        val ciudad: EditText = findViewById(R.id.mediccity)
        val direccion: EditText = findViewById(R.id.medicdirection)
        val contra: EditText = findViewById(R.id.medicRpassword)
        val rContra: EditText = findViewById(R.id.medicRpassword)
        //conexion con la base de datos
        val db = FirebaseFirestore.getInstance()
        //Permitir el cambio de interfaz a usuario mediante boton CANCELAR
        btn.setOnClickListener{

            val intent: Intent = Intent(this, sesion_admin:: class.java)
            startActivity(intent)
            finish()
        }
        //Boton REGISTRAR

        btn2.setOnClickListener{
            if (ci.text.isNotEmpty() && nombre.text.isNotEmpty() && apellido.text.isNotEmpty() && correo.text.isNotEmpty()
                && fecha.text.isNotEmpty() && ciudad.text.isNotEmpty() && direccion.text.isNotEmpty() && contra.text.isNotEmpty()
                && rContra.text.isNotEmpty()
            ) {
                //if(contra.text.equals(rContra)){
                val dato = hashMapOf(
                    "ci" to ci.text.toString(),
                    "name" to nombre.text.toString(),
                    "lastname" to apellido.text.toString(),
                    "email" to correo.text.toString(),
                    "date" to fecha.text.toString(),
                    "city" to ciudad.text.toString(),
                    "direction" to direccion.text.toString(),
                    "password" to contra.text.toString(),
                    "rol" to "medico"
                )
                db.collection("Usuarios").document(ci.text.toString())
                    .set(dato)
                    .addOnSuccessListener {
                        val intent: Intent = Intent(this, reg_exito::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .addOnFailureListener { e ->
                        Log.w(ContentValues.TAG, "hubo un error en el registro del usuario", e)
                    }


                /*}else{
                    Toast.makeText(this,"las contraseñas no son iguales",Toast.LENGTH_SHORT).show()
                }*/
            } else {
                Toast.makeText(this, "se deben rellenar todos los elementos", Toast.LENGTH_SHORT).show()

            }



            val intent: Intent = Intent(this, exito_regmedico:: class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla sesion admin
    override fun onBackPressed() {
        startActivity(Intent(this,sesion_admin::class.java))
        finish()
    }
}