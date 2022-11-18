package com.reservas_centromedico


import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.reservas_centromedico.model.Usuarios

class reg_usuario : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_usuario)
        //base de datos
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        //botones
        val register: Button = findViewById(R.id.button7)
        val cancel: Button = findViewById(R.id.button8)
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
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //init firebase auth

        //Permitir el cambio de interfaz a usuario mediante boton
        //realizar registro
        register.setOnClickListener {
            val cio = ci.text.toString()
            val username = nombre.text.toString()
            val lastname = apellido.text.toString()
            val email = correo.text.toString()
            val date = fecha.text.toString()
            val city = ciudad.text.toString()
            val direction = direccion.text.toString()
            val password= contra.text.toString()
            val rpassword = rContra.text.toString()

            if (cio.isEmpty() || username.isEmpty() || lastname.isEmpty() || email.isEmpty() || date.isEmpty()
                || city.isEmpty() || direction.isEmpty() || password.isEmpty() || rpassword.isEmpty()){
                if (cio.isEmpty()){
                    Toast.makeText(this, "la cedula esta vacia", Toast.LENGTH_SHORT).show()
                }
                if (username.isEmpty()){
                    Toast.makeText(this, "es necesario llenar el nombre", Toast.LENGTH_SHORT).show()
                }
                if (lastname.isEmpty()){
                    Toast.makeText(this, "es necesario colocar un apellido", Toast.LENGTH_SHORT).show()
                }
                if (date.isEmpty()){
                    Toast.makeText(this, "es necesario llenar la fecha de nacimiento", Toast.LENGTH_SHORT).show()
                }
                if (city.isEmpty()){
                    Toast.makeText(this, "es necesario colocar la ciudad", Toast.LENGTH_SHORT).show()
                }
                if (direction.isEmpty()){
                    Toast.makeText(this, "es necesario colocar una direccion", Toast.LENGTH_SHORT).show()
                }
                if (password.isEmpty()){
                    Toast.makeText(this, "es necesario establecer una contraseña", Toast.LENGTH_SHORT).show()
                }
                if (password.length <=5 ){
                    Toast.makeText(this, "contraseña muy corta", Toast.LENGTH_SHORT).show()
                }
            }else{
                if (password != rpassword){
                    Toast.makeText(this, "las contraseñas no sol iguales", Toast.LENGTH_SHORT).show()
                } else{
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val userref = database.reference.child("users").child(auth.currentUser!!.uid)
                            val users = Usuarios(cio, username, lastname, email, date, city, direction,
                                auth.currentUser!!.uid)

                            userref.setValue(users).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    val intent = Intent(this, reg_exito::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }else{
                            Toast.makeText(this, "fallo al registrar usuario", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        //cancelar registro
        cancel.setOnClickListener {
            val intent: Intent = Intent(this, inicio_usuario::class.java)
            startActivity(intent)
            finish()
        }
    }

    //Asignar que el boton atras regrese a la pantalla inicio sesion usuario
    override fun onBackPressed() {
        startActivity(Intent(this, inicio_usuario::class.java))
        finish()
    }
}

