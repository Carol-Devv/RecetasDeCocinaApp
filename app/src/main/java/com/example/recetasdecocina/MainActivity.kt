package com.example.recetasdecocina

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import com.example.recetasdecocina.databinding.ActivityMainBinding
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        copyDatabase(applicationContext)

        binding.etBuscarR.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // Obtener los límites del drawableEnd
                binding.etBuscarR.compoundDrawablesRelative[2]?.let { drawableEnd ->
                    val drawableWidth = drawableEnd.bounds.width()
                    // Verificar si el toque ocurrió dentro del área del drawableEnd
                    if (event.rawX >= (binding.etBuscarR.right - drawableWidth - binding.etBuscarR.paddingEnd)) {
                        val receta = binding.etBuscarR.text.toString().trim()

                        // Pasar los parámetros a la segunda Activity
                        val intent = Intent(this, RecipesActivity::class.java)

                        // Dependiendo de qué campo esté lleno, pasamos los parámetros
                        if (receta.isNotEmpty()) {
                            intent.putExtra("receta", receta)
                            intent.putExtra("tipo_busqueda", "receta") // Indicar que la búsqueda es por ingrediente
                        }

                        startActivity(intent)
                    }
                }
            }
            false
        }

        binding.etBuscarI.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // Obtener los límites del drawableEnd
                binding.etBuscarI.compoundDrawablesRelative[2]?.let { drawableEnd ->
                    val drawableWidth = drawableEnd.bounds.width()
                    // Verificar si el toque ocurrió dentro del área del drawableEnd
                    if (event.rawX >= (binding.etBuscarI.right - drawableWidth - binding.etBuscarI.paddingEnd)) {
                        val ingrediente = binding.etBuscarI.text.toString().trim()

                        // Pasar los parámetros a la segunda Activity
                        val intent = Intent(this, RecipesActivity::class.java)

                        // Dependiendo de qué campo esté lleno, pasamos los parámetros
                        if (ingrediente.isNotEmpty()) {
                            intent.putExtra("ingrediente", ingrediente)
                            intent.putExtra("tipo_busqueda", "ingrediente") // Indicar que la búsqueda es por nombre
                        }
                        startActivity(intent)
                    }
                }
            }
            false
        }

        binding.btnSalir.setOnClickListener {
            finishAndRemoveTask()
        }


    }
    fun copyDatabase(context: Context) {
        val dbFile = context.getDatabasePath("recetas.sqlite")

        // Verificar si el archivo de base de datos ya existe
        if (!dbFile.exists()) {
            try {
                // Crear las carpetas necesarias si no existen
                dbFile.parentFile?.mkdirs()

                // Abrir el archivo de la base de datos en assets
                val inputStream: InputStream = context.assets.open("recetas.sqlite")
                val outputStream: OutputStream = FileOutputStream(dbFile)

                // Copiar el archivo de base de datos desde assets a la carpeta interna
                val buffer = ByteArray(1024)
                var length: Int
                while (inputStream.read(buffer).also {
                        length = it
                    } > 0) {
                    outputStream.write(buffer, 0, length)
                }

                // Cerrar los streams
                inputStream.close()
                outputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}