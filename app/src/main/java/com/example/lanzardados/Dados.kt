package com.example.lanzardados

import kotlin.random.Random
import kotlin.random.nextInt

class Dados {
    private lateinit var numerosDados: Array<Int>
    private var nombreDados = arrayOf(R.drawable.dice_one, R.drawable.dice_two,
        R.drawable.dice_three, R.drawable.dice_four,
        R.drawable.dice_five, R.drawable.dice_six)

    fun lanzarDados(): Array<Int>{

        val numeroDado1 = Random.nextInt(0..5)
        val numeroDado2 = Random.nextInt(0..5)

        numerosDados = arrayOf(nombreDados[numeroDado1], nombreDados[numeroDado2])

        return numerosDados
    }
}