package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class sesion_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion_admin)

        //Si el administrador presiona salir regresa a pantalla principal
        val btn: Button = findViewById(R.id.button20)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, main_screen:: class.java)
            startActivity(intent)
            finish()
        }
        //Si el administrador presiona REGRESAR, regresa a pantalla login admin
        val btn2: Button = findViewById(R.id.button19)
        btn2.setOnClickListener{

            val intent: Intent = Intent(this, inicio_admin:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea el boton registrar medico
        val btn3: Button = findViewById(R.id.button13)
        btn3.setOnClickListener{

            val intent: Intent = Intent(this, Lreg_medico:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea el boton modificar medico
        val btn4: Button = findViewById(R.id.button15)
        btn4.setOnClickListener{

            val intent: Intent = Intent(this, admin_modmedico:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea el boton modificar paciente
        val btn5: Button = findViewById(R.id.button16)
        btn5.setOnClickListener{

            val intent: Intent = Intent(this, admin_modpaciente:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea boton lista de medicos
        val btn6: Button = findViewById(R.id.button17)
        btn6.setOnClickListener{

            val intent: Intent = Intent(this, admin_listmedico:: class.java)
            startActivity(intent)
            finish()
        }
        //Se crea boton lista de citas
        val btn7: Button = findViewById(R.id.button18)
        btn7.setOnClickListener{

            val intent: Intent = Intent(this, admin_listcitas:: class.java)
            startActivity(intent)
            finish()
        }
    }
    //Asignar que el boton atras regrese a la pantalla login admin
    override fun onBackPressed() {
        startActivity(Intent(this,inicio_admin::class.java))
        finish()
    }
}