package com.example.lanzardados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var dado1: ImageView
    private lateinit var dado2: ImageView
    private lateinit var dado3: ImageView
    private lateinit var dado4: ImageView
    private lateinit var dado5: ImageView
    private lateinit var dado6: ImageView
    private lateinit var botonAgregar: ImageView
    private lateinit var botonRestar: ImageView

    private lateinit var botonLanzarDados: Button

    private lateinit var dadosIndicador: TextView
    private lateinit var dados: Array<ImageView>
    private var dadosImagen = arrayOf(R.drawable.dice_one, R.drawable.dice_two,
        R.drawable.dice_three, R.drawable.dice_four,
        R.drawable.dice_five, R.drawable.dice_six)

    private lateinit var texto: String
    private var dadosCantidad = 0
    private var botonPulsado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dado1 = findViewById(R.id.dado1)
        dado2 = findViewById(R.id.dado2)
        dado3 = findViewById(R.id.dado3)
        dado4 = findViewById(R.id.dado4)
        dado5 = findViewById(R.id.dado5)
        dado6 = findViewById(R.id.dado6)

        botonAgregar = findViewById(R.id.agregarBoton)
        botonRestar = findViewById(R.id.restarBoton)
        botonLanzarDados = findViewById(R.id.botonLanzarDados)

        dadosIndicador = findViewById(R.id.dadosIndicador)

        dados = arrayOf(dado1, dado2, dado3, dado4, dado5, dado6)
        dados[0].visibility = View.GONE
        dados[1].visibility = View.GONE
        dados[2].visibility = View.GONE
        dados[3].visibility = View.GONE
        dados[4].visibility = View.GONE
        dados[5].visibility = View.GONE

        texto = "$dadosCantidad DADOS"
        dadosIndicador.text = texto

        botonLanzarDados.setOnClickListener {
            if(dadosCantidad == 0){
                Toast.makeText(this, "Seleccione la cantidad de dados a lanzar", Toast.LENGTH_SHORT).show()
            }
            else{
                lanzarDados(dadosCantidad, 0)
                botonPulsado = true
            }
        }

        botonAgregar.setOnClickListener {
            when(dadosCantidad){
                0 -> {
                    dadosCantidad += 1
                    texto = "$dadosCantidad DADO"
                    dadosIndicador.text = texto
                }
                in 1..5 -> {
                    dadosCantidad += 1
                    texto = "$dadosCantidad DADOS"
                    dadosIndicador.text = texto
                }
                6 -> {
                    texto = "$dadosCantidad DADOS"
                    dadosIndicador.text = texto
                }
            }

            if(botonPulsado){
                dados[dadosCantidad - 1].visibility = View.VISIBLE
            }
        }

        botonRestar.setOnClickListener {
            when(dadosCantidad){
                1 -> {
                    dadosCantidad = 0
                    texto = "0 DADOS"
                    dadosIndicador.text = texto
                }
                2 -> {
                    dadosCantidad -= 1
                    texto = "$dadosCantidad DADO"
                    dadosIndicador.text = texto
                }
                in 3..6 ->{
                    dadosCantidad -= 1
                    texto = "$dadosCantidad DADOS"
                    dadosIndicador.text = texto
                }
            }

            if(botonPulsado){
                dados[dadosCantidad].visibility = View.GONE
            }
        }
    }

    private fun lanzarDados(cantidad: Int, contador: Int){

        if (cantidad != 0) {
            val aleatorio = Random.nextInt(0..5)
            dados[contador].setImageResource(dadosImagen[aleatorio])
            dados[contador].visibility = View.VISIBLE
            println(aleatorio)
            lanzarDados(cantidad - 1, contador + 1)
        }
    }
}