package com.example.proyectorecetas_jeancarlos_kevin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detalleReceta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_receta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener los datos pasados a la actividad
        val recetaNombre = intent.getStringExtra("recetaNombre")
        val recetaIngredientes = intent.getStringExtra("recetaIngredientes")
        val recetaPasos = intent.getStringExtra("recetaPasos")
        val recetaImagenUri = intent.getStringExtra("recetaImagenUri")

        // Referenciar las vistas
        val nombreRecetaTextView = findViewById<TextView>(R.id.nombreRecetaDetalle)
        val ingredientesRecetaTextView = findViewById<TextView>(R.id.ingredientesRecetaDetalle)
        val pasoAPasoRecetaTextView = findViewById<TextView>(R.id.pasoAPasoRecetaDetalle)
        val imagenRecetaImageView = findViewById<ImageView>(R.id.imagenRecetaDetalle)

        // Establecer los valores
        nombreRecetaTextView.text = recetaNombre
        ingredientesRecetaTextView.text = "Ingredientes: $recetaIngredientes"
        pasoAPasoRecetaTextView.text = "Pasos: $recetaPasos"

        // Usar la URI de la imagen si está disponible
        if (!recetaImagenUri.isNullOrEmpty()) {
            imagenRecetaImageView.setImageURI(Uri.parse(recetaImagenUri))
        }

        val regresar: Button = findViewById(R.id.bontonRegresar)

        regresar.setOnClickListener {
            val intent = Intent(this, listaRecetas::class.java)
            startActivity(intent)
        }


    }
}