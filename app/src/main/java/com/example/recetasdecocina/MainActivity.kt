package com.example.recetasdecocina

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import com.example.recetasdecocina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etBuscarR.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // Obtener los límites del drawableEnd
                binding.etBuscarR.compoundDrawablesRelative[2]?.let { drawableEnd ->
                    val drawableWidth = drawableEnd.bounds.width()
                    // Verificar si el toque ocurrió dentro del área del drawableEnd
                    if (event.rawX >= (binding.etBuscarR.right - drawableWidth - binding.etBuscarR.paddingEnd)) {
                        // Acción para el botón del drawableEnd
                        Toast.makeText(this, "DrawableEnd presionado", Toast.LENGTH_SHORT).show()
                        return@setOnTouchListener true
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
                        // Acción para el botón del drawableEnd
                        Toast.makeText(this, "DrawableEnd presionado", Toast.LENGTH_SHORT).show()
                        return@setOnTouchListener true
                    }
                }
            }
            false
        }

        binding.btnSalir.setOnClickListener {
            finishAndRemoveTask()
        }
    }


}