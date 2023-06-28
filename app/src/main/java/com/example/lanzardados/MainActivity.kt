package com.example.lanzardados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var dado1: ImageView
    private lateinit var dado2: ImageView
    private lateinit var botonLanzarDados: Button
    private lateinit var dadosNumeros: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dado1 = findViewById(R.id.dado1)
        dado2 = findViewById(R.id.dado2)
        botonLanzarDados = findViewById(R.id.botonLanzarDados)

        dado1.visibility = View.INVISIBLE
        dado2.visibility = View.INVISIBLE

        val dados = Dados()

        botonLanzarDados.setOnClickListener {
            dadosNumeros = dados.lanzarDados()

            dado1.setImageResource(dadosNumeros[0])
            dado2.setImageResource(dadosNumeros[1])

            dado1.visibility = View.VISIBLE
            dado2.visibility = View.VISIBLE
        }
    }
}