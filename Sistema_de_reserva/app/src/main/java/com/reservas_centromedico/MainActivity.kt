package com.reservas_centromedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide

//Splash screen
class MainActivity : AppCompatActivity() {
    //Definir duración del splash screen
    val DURACION: Long = 3000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ocultar barra superior, volver pantalla completa
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Recibir la imagen mediante su id
        val logo = findViewById<ImageView>(R.id.imageView)

        Glide.with(this).load(R.drawable.logo_uleam).into(logo)

        //Metodo para cambiar de actividad transcurridos los 3 segundos
        cambiarActivity()
    }
    private fun cambiarActivity() {
        Handler().postDelayed(Runnable {
            val intent = Intent(this, main_screen::class.java)
            startActivity(intent)
            finish()
        }, DURACION)
    }
}