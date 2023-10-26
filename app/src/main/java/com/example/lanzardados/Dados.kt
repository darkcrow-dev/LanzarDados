package com.example.lanzardados

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt

class Dados(private var imagenesDados: Array<ImageView>, private var dadosImagen: Array<Int>,
            private var arrayLayoutDados: Array<LinearLayout>, private var dadosIndicador: TextView,
            private var contexto: Context) {

    private var dadosCantidad = 0
    private var botonPulsado = false

    fun inicializarDados(contador: Int){
        if(contador > 5){
            botonPulsado = false
            dadosCantidad = 0
            val texto = "0 DADOS"
            dadosIndicador.text = texto
            visualizarDados(dadosCantidad)
            return
        }

        imagenesDados[contador].visibility = View.GONE
        inicializarDados(contador + 1)
    }

    fun visualizarDados(cantidad: Int){
        when(cantidad){
            0 -> {
                arrayLayoutDados[0].visibility = View.GONE
                arrayLayoutDados[1].visibility = View.GONE
                arrayLayoutDados[2].visibility = View.GONE
            }
            in 1..2 -> {
                arrayLayoutDados[0].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 3F)

                arrayLayoutDados[0].visibility = View.VISIBLE
                arrayLayoutDados[1].visibility = View.GONE
                arrayLayoutDados[2].visibility = View.GONE
            }
            in 3..4 -> {
                arrayLayoutDados[0].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1.5F)
                arrayLayoutDados[1].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1.5F)

                arrayLayoutDados[1].visibility = View.VISIBLE
                arrayLayoutDados[2].visibility = View.GONE
            }
            in 5..6 -> {
                arrayLayoutDados[0].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1F)
                arrayLayoutDados[1].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1F)
                arrayLayoutDados[2].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1F)

                arrayLayoutDados[2].visibility = View.VISIBLE
            }
        }
    }

    fun agregarDados(botonPulsado: Boolean){
        var texto = ""
        when(dadosCantidad){
            0 -> {
                dadosCantidad += 1
                texto = "$dadosCantidad DADO"
            }
            in 1..5 -> {
                dadosCantidad += 1
                texto = "$dadosCantidad DADOS"
            }
            6 -> {
                texto = "$dadosCantidad DADOS"
            }
        }

        dadosIndicador.text = texto
        if(botonPulsado){
            imagenesDados[dadosCantidad - 1].visibility = View.VISIBLE
            visualizarDados(dadosCantidad)
        }
    }

    fun quitarDados(botonPulsado: Boolean){
        var texto = "0 DADOS"
        when(dadosCantidad){
            1 -> {
                dadosCantidad = 0
            }
            2 -> {
                dadosCantidad -= 1
                texto = "$dadosCantidad DADO"

            }
            in 3..6 -> {
                dadosCantidad -= 1
                texto = "$dadosCantidad DADOS"
            }
        }

        dadosIndicador.text = texto
        if(botonPulsado){
            imagenesDados[dadosCantidad].visibility = View.GONE
            visualizarDados(dadosCantidad)
        }
    }

    fun lanzarDados(cantidad: Int, contador: Int){
        if(dadosCantidad == 0){
            Toast.makeText(contexto, "Seleccione la cantidad de dados a lanzar", Toast.LENGTH_SHORT).show()
            return
        }

        lanzamiento(cantidad, contador)
        visualizarDados(cantidad)
        botonPulsado = true
    }

    private fun lanzamiento(cantidad: Int, contador: Int){
        if (cantidad != 0) {
            val aleatorio = Random.nextInt(0..5)
            imagenesDados[contador].setImageResource(dadosImagen[aleatorio])
            imagenesDados[contador].visibility = View.VISIBLE
            lanzarDados(cantidad - 1, contador + 1)
        }
    }

    fun getDadosCantidad(): Int {
        return dadosCantidad
    }

    fun getBotonPulsado(): Boolean {
        return botonPulsado
    }
}