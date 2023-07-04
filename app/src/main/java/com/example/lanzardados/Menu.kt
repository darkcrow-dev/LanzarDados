package com.example.lanzardados

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class Menu : AppCompatActivity() {
    private lateinit var botonJugar: Button
    private lateinit var botonInformacion: Button
    private lateinit var imagenDado1: ImageView
    private lateinit var imagenDado2: ImageView

    private var nombreDados = arrayOf(R.drawable.dice_one, R.drawable.dice_two,
        R.drawable.dice_three, R.drawable.dice_four,
        R.drawable.dice_five, R.drawable.dice_six)

    private val numeroDado1 = Random.nextInt(0..5)
    private val numeroDado2 = Random.nextInt(0..5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        botonJugar = findViewById(R.id.botonJugar)
        botonInformacion = findViewById(R.id.botonInformacion)
        imagenDado1 = findViewById(R.id.imagenDado1)
        imagenDado2 = findViewById(R.id.imagenDado2)

        imagenDado1.setImageResource(nombreDados[numeroDado1])
        imagenDado2.setImageResource(nombreDados[numeroDado2])


        botonJugar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        botonInformacion.setOnClickListener {
            informacion()
        }
    }

    private fun informacion(){
        val dialogo = Dialog(this)
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogo.setCancelable(true)
        dialogo.setCanceledOnTouchOutside(false)
        dialogo.setContentView(R.layout.information_dialog)
        dialogo.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val botonCorrecto: Button = dialogo.findViewById(R.id.botonCorrecto)
        val textoInformacion: TextView = dialogo.findViewById(R.id.textoInformacion)

        val texto = "Lanza los dados en este simulador y observa el resultado obtenido"

        textoInformacion.text = texto

        botonCorrecto.setOnClickListener {
            dialogo.dismiss()
        }

        dialogo.show()
    }
}