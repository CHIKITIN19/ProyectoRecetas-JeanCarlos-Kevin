package com.example.proyectorecetas_jeancarlos_kevin

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class prueba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prueba)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Referencias a las vistas
        val nombrePlatilloTextView: TextView = findViewById(R.id.nombrePlatilloTextView)
        val ingredientesTextView: TextView = findViewById(R.id.ingredientesTextView)
        val pasoAPasoTextView: TextView = findViewById(R.id.pasoAPasoTextView)
        val imagenImageView: ImageView = findViewById(R.id.imagenImageView)

        // Obtener los datos del Intent
        val nombrePlatillo = intent.getStringExtra("nombrePlatillo")
        val ingredientes = intent.getStringExtra("ingredientes")
        val pasoAPaso = intent.getStringExtra("pasoAPaso")
        val imagenUri = intent.getStringExtra("imagenUri")?.let { Uri.parse(it) }

        // Mostrar los datos en las vistas
        nombrePlatilloTextView.text = nombrePlatillo
        ingredientesTextView.text = ingredientes
        pasoAPasoTextView.text = pasoAPaso
        imagenUri?.let { imagenImageView.setImageURI(it) }

    }
}