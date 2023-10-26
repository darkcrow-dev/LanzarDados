package com.example.lanzardados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var dado1: ImageView
    private lateinit var dado2: ImageView
    private lateinit var dado3: ImageView
    private lateinit var dado4: ImageView
    private lateinit var dado5: ImageView
    private lateinit var dado6: ImageView

    private lateinit var botonAgregar: ImageView
    private lateinit var botonQuitar: ImageView

    private lateinit var botonLanzarDados: Button
    private lateinit var dadosIndicador: TextView

    private lateinit var parDados1: LinearLayout
    private lateinit var parDados2: LinearLayout
    private lateinit var parDados3: LinearLayout

    private var arrayDadosImagen = arrayOf(R.drawable.dice_one, R.drawable.dice_two,
        R.drawable.dice_three, R.drawable.dice_four,
        R.drawable.dice_five, R.drawable.dice_six)

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
        botonQuitar = findViewById(R.id.quitarBoton)

        botonLanzarDados = findViewById(R.id.botonLanzarDados)
        dadosIndicador = findViewById(R.id.dadosIndicador)

        parDados1 = findViewById(R.id.parDados1)
        parDados2 = findViewById(R.id.parDados2)
        parDados3 = findViewById(R.id.parDados3)

        val arrayDados = arrayOf(dado1, dado2, dado3, dado4, dado5, dado6)
        val arrayLayoutDados = arrayOf(parDados1, parDados2, parDados3)

        val dados = Dados(arrayDados, arrayDadosImagen, arrayLayoutDados, dadosIndicador, this)
        dados.setBotonPulsado(false)
        dados.setDadosCantidad(0)
        dados.inicializarDados(0)
        dados.visualizarDados(0)

        botonLanzarDados.setOnClickListener {
            dados.lanzarDados(dados.getDadosCantidad(), 0)
        }

        botonAgregar.setOnClickListener {
            dados.agregarDados(dados.getBotonPulsado())
        }

        botonQuitar.setOnClickListener {
            dados.quitarDados(dados.getBotonPulsado())
        }
    }
}