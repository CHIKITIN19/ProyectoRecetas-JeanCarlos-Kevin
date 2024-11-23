package com.example.proyectorecetas_jeancarlos_kevin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ingresarReceta : AppCompatActivity() {

    private lateinit var nombrePlatilloEditText: EditText
    private lateinit var ingredientesEditText: EditText
    private lateinit var pasoAPasoEditText: EditText
    private lateinit var seleccionarImagenButton: Button
    private lateinit var agregarRecetaButton: Button
    private lateinit var imagenPreview: ImageView

    private var imagenUri: Uri? = null

    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
            uri: Uri? ->
            imagenUri = uri
            imagenPreview.setImageURI(uri) // Mostrar la imagen seleccionada
            imagenPreview.visibility = ImageView.VISIBLE // Hacer visible el ImageView

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_receta)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Asignación de vistas
        nombrePlatilloEditText = findViewById(R.id.nombretxt)
        ingredientesEditText = findViewById(R.id.ingredientestxt)
        pasoAPasoEditText = findViewById(R.id.pasostxt)
        seleccionarImagenButton = findViewById(R.id.seleccionarImagenBtn)
        agregarRecetaButton = findViewById(R.id.agregarRecetaBtn)
        imagenPreview = findViewById(R.id.imagenPreview)

        // Configuración del botón para seleccionar una imagen
        seleccionarImagenButton.setOnClickListener {
            seleccionarImagen()
        }

        // Configuración del botón para agregar la receta
        agregarRecetaButton.setOnClickListener {
            agregarReceta()
        }

        val regresar: Button = findViewById(R.id.bontonRegresar)

        regresar.setOnClickListener {
            val intent = Intent(this, listaRecetas::class.java)
            startActivity(intent)
        }
    }

    private fun seleccionarImagen() {
        // Abrir la galería para seleccionar una imagen
        imagePickerLauncher.launch("image/*")
    }


    // Al hacer clic en el botón para agregar la receta
private fun agregarReceta() {
    val nombrePlatillo = nombrePlatilloEditText.text.toString()
    val ingredientes = ingredientesEditText.text.toString()
    val pasoAPaso = pasoAPasoEditText.text.toString()

    if (nombrePlatillo.isNotEmpty() && ingredientes.isNotEmpty() && pasoAPaso.isNotEmpty() && imagenUri != null) {
        val nuevaReceta = receta(nombrePlatillo, ingredientes, pasoAPaso, imagenUri.toString())

        recetaLista.recetas.add(nuevaReceta)


        // Lanzar la actividad de lista de recetas
        val intent = Intent(this, listaRecetas::class.java)
        startActivity(intent)
    } else {
        Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
    }
}

}
