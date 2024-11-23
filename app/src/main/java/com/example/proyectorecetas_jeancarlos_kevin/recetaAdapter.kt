import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.net.Uri
import com.example.proyectorecetas_jeancarlos_kevin.R
import com.example.proyectorecetas_jeancarlos_kevin.detalleReceta
import com.example.proyectorecetas_jeancarlos_kevin.receta

class recetaAdapter(private val context: Context, private val recetas: List<receta>) : BaseAdapter() {

    override fun getCount(): Int {
        return recetas.size
    }

    override fun getItem(position: Int): Any {
        return recetas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Crear o reciclar la vista del item
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_receta, parent, false)

        // Obtener la receta en la posición actual
        val receta = recetas[position]

        // Referenciar las vistas del layout
        val nombreRecetaTextView = view.findViewById<TextView>(R.id.nombreReceta)

        val imagenRecetaImageView = view.findViewById<ImageView>(R.id.imagenReceta)

        // Establecer los valores en las vistas
        nombreRecetaTextView.text = receta.nombre


        // Usar la URI de la imagen si está disponible
        if (receta.imagenUri != null) {
            imagenRecetaImageView.setImageURI(Uri.parse(receta.imagenUri))
        }

        // Configurar un clic en el item de la lista
        view.setOnClickListener {
            val intent = Intent(context, detalleReceta::class.java).apply {
                putExtra("recetaNombre", receta.nombre)
                putExtra("recetaIngredientes", receta.ingredientes)
                putExtra("recetaPasos", receta.pasos)
                putExtra("recetaImagenUri", receta.imagenUri)
            }
            context.startActivity(intent)
        }

        return view
    }
}
