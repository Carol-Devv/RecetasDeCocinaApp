package com.example.recetasdecocina

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.recetasdecocina.databinding.ListItemBinding

class ListAdapter(
    context: Context,
    resource: Int,
    private val recipeList: MutableList<Receta>
) : ArrayAdapter<Receta>(context, resource, recipeList) {

    fun getData(): MutableList<Receta> {
        return recipeList
    }

    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val receta: Receta? = getItem(position)
        val binding = if (convertView == null) {
            val inflater = LayoutInflater.from(parent.context)
            ListItemBinding.inflate(inflater, parent, false)
        } else {
            ListItemBinding.bind(convertView)
        }

        receta?.let { item ->
            binding.tituloReceta.text = item.nombre

            when (item.id) {
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
        return binding.root
    }

}