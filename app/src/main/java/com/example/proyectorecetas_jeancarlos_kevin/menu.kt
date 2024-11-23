package com.example.proyectorecetas_jeancarlos_kevin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lista: Button = findViewById(R.id.btnListaReceta)
        val ingresar: Button = findViewById(R.id.btnIngresarReceta)

        lista.setOnClickListener {
           val intent = Intent(this, listaRecetas::class.java)
           startActivity(intent)
        }
        ingresar.setOnClickListener {
            val intent = Intent(this, ingresarReceta::class.java)
            startActivity(intent)
        }
    }
}