package com.example.proyectorecetas_jeancarlos_kevin


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectorecetas_jeancarlos_kevin.R
import com.example.proyectorecetas_jeancarlos_kevin.receta
import com.example.proyectorecetas_jeancarlos_kevin.recetaLista
import recetaAdapter

class listaRecetas : AppCompatActivity() {

    private lateinit var listViewRecetas: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_recetas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lista: Button = findViewById(R.id.botonIngresar)

        lista.setOnClickListener {
            val intent = Intent(this, ingresarReceta::class.java)
            startActivity(intent)
        }


        // Referenciar el ListView
        listViewRecetas = findViewById(R.id.listViewRecetas)

        // Acceder a la lista de recetas del RecetaRepository
        val recetas = recetaLista.recetas

        // Crear un adaptador personalizado para mostrar las recetas en el ListView
        val recetaListAdapter = recetaAdapter(this, recetas)

        // Asignar el adaptador al ListView
        listViewRecetas.adapter = recetaListAdapter
    }
}
