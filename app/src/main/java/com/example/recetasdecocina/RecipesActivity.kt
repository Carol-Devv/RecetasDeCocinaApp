package com.example.recetasdecocina

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recetasdecocina.databinding.ActivityRecipesBinding

@SuppressLint("Range")
class RecipesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipesBinding
    private lateinit var dbHelper: SQLiteOpenHelper
    private lateinit var db: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = RecetaDatabaseHelper(this)
        db = dbHelper.readableDatabase

        val tipoBusqueda = intent.getStringExtra("tipo_busqueda")
        val recetaBusqueda = intent.getStringExtra("receta")
        val ingredienteBusqueda = intent.getStringExtra("ingrediente")

        val results = when (tipoBusqueda) {
            "receta" -> searchByName(recetaBusqueda ?: "")
            "ingrediente" -> searchByIngredient(ingredienteBusqueda ?: "")
            else -> {
                Toast.makeText(this, "No hay coincidencias", Toast.LENGTH_SHORT).show()
                mutableListOf<Receta>()
            }
        }
        // Mostrar los resultados en un ListView
        // Asegúrate de adaptar este código al formato de tu lista de resultados
        val listAdapter = ListAdapter(this, R.layout.list_item, results.toMutableList())
        binding.listaRecetas.adapter = listAdapter
        binding.listaRecetas.setOnItemClickListener { parent, view, position, id ->
            // Pasar los parámetros a la segunda Activity
            val intent = Intent(this, RecipeDetailsActivity::class.java)
            val receta = parent.getItemAtPosition(position) as Receta
            intent.putExtra("titulo", receta.nombre)
            intent.putExtra("modo_de_preparacion", receta.modo_de_preparacion)
            intent.putExtra("ingredientes", receta.ingredientes)
            intent.putExtra("tiempo_total", receta.tiempo_total)
            intent.putExtra("id", receta.id)
            intent.putExtra("tipo_busqueda", "receta") // Indicar que la búsqueda es por ingrediente

            startActivity(intent)
        }


        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }

    // Función para buscar por nombre de receta
    private fun searchByName(query: String): List<Receta> {
        val cursor: Cursor = db.rawQuery(
            "SELECT id, nombre, ingredientes, modo_de_preparacion, tiempo_total FROM recetas WHERE nombre LIKE ?",
            arrayOf("%$query%")
        )

        val results = mutableListOf<Receta>()
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
            val ingredientes = cursor.getString(cursor.getColumnIndex("ingredientes"))
            val modo_de_preparacion = cursor.getString(cursor.getColumnIndex("modo_de_preparacion"))
            val tiempo_total = cursor.getInt(cursor.getColumnIndex("tiempo_total"))
            results.add(Receta(id, nombre, ingredientes, modo_de_preparacion, tiempo_total))
        }
        cursor.close()
        db.close()
        return results
    }

    // Función para buscar por ingrediente
    private fun searchByIngredient(query: String): List<Receta> {
        val cursor: Cursor = db.rawQuery(
            "SELECT id, nombre, ingredientes, modo_de_preparacion, tiempo_total FROM recetas WHERE ingredientes LIKE ?",
            arrayOf("%$query%")
        )

        val results = mutableListOf<Receta>()
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
            val ingredientes = cursor.getString(cursor.getColumnIndex("ingredientes"))
            val modo_de_preparacion = cursor.getString(cursor.getColumnIndex("modo_de_preparacion"))
            val tiempo_total = cursor.getInt(cursor.getColumnIndex("tiempo_total"))
            results.add(Receta(id, nombre, ingredientes, modo_de_preparacion, tiempo_total))
        }
        cursor.close()
        db.close()
        return results
    }

}