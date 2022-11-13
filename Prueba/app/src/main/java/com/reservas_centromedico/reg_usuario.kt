package com.reservas_centromedico

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class reg_usuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_usuario)

        //conexion a la base de datos
        val db = FirebaseFirestore.getInstance()
        //botones
        val register: Button = findViewById(R.id.button7 )
        val cancel: Button = findViewById(R.id.button8 )
        //datos de registro
        val ci: EditText = findViewById(R.id.CI)
        val nombre: EditText = findViewById(R.id.name)
        val apellido: EditText = findViewById(R.id.lastname)
        val correo: EditText = findViewById(R.id.email)
        val fecha: EditText = findViewById(R.id.date)
        val ciudad: EditText = findViewById(R.id.city)
        val direccion: EditText = findViewById(R.id.Direction)
        val contra: EditText = findViewById(R.id.password)
        val rContra: EditText = findViewById(R.id.rpassword)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Permitir el cambio de interfaz a usuario mediante boton
        //realizar registro
        register.setOnClickListener{
            if(ci.text.isNotEmpty() && nombre.text.isNotEmpty() && apellido.text.isNotEmpty() && correo.text.isNotEmpty()
                && fecha.text.isNotEmpty() && ciudad.text.isNotEmpty() && direccion.text.isNotEmpty() && contra.text.isNotEmpty()
                && rContra.text.isNotEmpty()){
                //if(contra.text.equals(rContra)){
                    val dato = hashMapOf(
                        //"ci" to CI.text,
                        "name" to nombre.text.toString(),
                        "lastname" to apellido.text.toString(),
                        "email" to correo.text.toString(),
                        "date" to fecha.text.toString(),
                        "city" to ciudad.text.toString(),
                        "direction" to direccion.text.toString(),
                        "password" to contra.text.toString(),
                        "rol" to "paciente")
                    db.collection("Usuarios").document(ci.text.toString())
                        .set(dato)
                        .addOnSuccessListener {
                            val intent:Intent= Intent(this, reg_exito:: class.java)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener {
                                e -> Log.w(TAG, "hubo un error en el registro del usuario", e) }


                /*}else{
                    Toast.makeText(this,"las contraseñas no son iguales",Toast.LENGTH_SHORT).show()
                }*/
            }else{
                Toast.makeText(this,"se deben rellenar todos los elementos",Toast.LENGTH_SHORT).show()

            }

        }
        //cancelar registro
        cancel.setOnClickListener{
            val intent:Intent=Intent(this, inicio_usuario:: class.java)
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