package com.example.recetasdecocina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recetasdecocina.databinding.ActivityRecipeDetailsBinding

class RecipeDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecipeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getStringExtra("id")
        val titulo = intent.getStringExtra("titulo")
        val modo_de_preparacion = intent.getStringExtra("modo_de_preparacion")
        val ingredientes = intent.getStringExtra("ingredientes")
        val tiempo_total = intent.getStringExtra("tiempo_total")

        binding.tituloReceta.text = titulo
        binding.ingredientesReceta.text = ingredientes
        binding.descripcionReceta.text = modo_de_preparacion
        binding.tiempoReceta.text = tiempo_total

        when (id?.toInt()) {
            1 -> {
                binding.fotoReceta.setImageResource(R.drawable.tarta_choc_fram)
            }

            2 -> {
                binding.fotoReceta.setImageResource(R.drawable.pollo)
            }

            3 -> {
                binding.fotoReceta.setImageResource(R.drawable.tarta_queso)
            }

            4 -> {
                binding.fotoReceta.setImageResource(R.drawable.arroz)
            }

            5 -> {
                binding.fotoReceta.setImageResource(R.drawable.crema_champ)
            }

            6 -> {
                binding.fotoReceta.setImageResource(R.drawable.serranito)
            }

            7 -> {
                binding.fotoReceta.setImageResource(R.drawable.atun)
            }

            8 -> {
                binding.fotoReceta.setImageResource(R.drawable.solomillo)
            }

            9 -> {
                binding.fotoReceta.setImageResource(R.drawable.salmon)
            }

            10 -> {
                binding.fotoReceta.setImageResource(R.drawable.esparragos)
            }
        }


    }
}