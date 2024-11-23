package com.example.proyectorecetas_jeancarlos_kevin

import android.net.Uri

data class receta(
    val nombre: String,
    val ingredientes: String,
    val pasos: String,
    val imagenUri: String?
)
