package com.example.proyectorecetas_jeancarlos_kevin

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Se inicializan recetas por defecto
        val recetauno = receta("Ensalada de pollo y lechuga con elote", "1 Lata Media Crema NESTLÉ® Reducida en Grasa, 1/2 Paquete Queso crema, light 1 Lata Granos de elote amarillo enlatado escurridos (200 g), 1 Pieza Lechuga escarola desinfectada y cortada, 400 Gramos Pechuga de pollo cocida y deshebrada, 1 1/2 Cucharaditas Sal con cebolla en polvo", "Para el aderezo, licúa la Media Crema NESTLÉ® Reducida en Grasa* con el queso crema y sal con cebolla, En un recipiente mezcla el pollo deshebrado, los granos de elote, la lechuga y el aderezo. , Ofrece.", "android.resource://com.example.proyectorecetas_jeancarlos_kevin/"+R.drawable.ensalada_pollo)
        val recetados = receta("Ensalada de atún", "1 Lechuga italiana desinfectada, 2 Latas de atún en agua escurridas (140 g c/u), 1 Taza de granos de elote amarillo, 200 Gramos de queso panela cortado en cubos, 2 Jitomates cortados en gajos, 1/2 Taza de aceite de oliva, 1 Limón su jugo", "En un tazón mezcla la lechuga con el atún en agua, el elote, el queso panela y los jitomates, Para la vinagreta, licúa el aceite de oliva con el jugo de limón, el Jugo MAGGI®, la Salsa Tipo Inglesa CROSSE & BLACKWELL® y la pimienta, Sirve la ensalada acompañando con la vinagreta", "android.resource://com.example.proyectorecetas_jeancarlos_kevin/"+R.drawable.ensalada_atun)
        recetaLista.recetas.add(recetauno)
        recetaLista.recetas.add(recetados)

        // Carga de animaciones de la pantalla principal
        var topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        var bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        val imagen: ImageView = findViewById(R.id.imgLogo)
        val titulo: TextView = findViewById(R.id.txtTitulo)

        // asignamos las animaciones

        imagen.startAnimation(topAnim)
        titulo.startAnimation(bottomAnim)

        // cuando termine la animacion vamos a otra ventana
        bottomAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // en este caso no se hace nada
            }

            override fun onAnimationEnd(animation: Animation?) {
                //aca termina la animacion
                val intent = Intent(this@MainActivity, listaRecetas::class.java)
                startActivity(intent)
                finish()//esto es para que no se devuelvan a la pantalla de carga
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // en este caso no se hace nada
            }
        })



    }
}