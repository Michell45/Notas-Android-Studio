package com.example.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  calcularboton:Button=findViewById(R.id.calcularbtn)
        calcularboton.setOnClickListener{realizarcalculo()}

    }

    private fun realizarcalculo() {
        val campoNombre:EditText=findViewById(R.id.idnombretxt)
        val campoNota1:EditText=findViewById(R.id.idnota1text)
        val campoNota2:EditText=findViewById(R.id.idnota2text)
        val campoNota3:EditText=findViewById(R.id.idnota3text)
        val mensajeresult:TextView=findViewById(R.id.txtResult)


        val nombre:String=campoNombre.text.toString()
        val nota1:Double=campoNota1.text.toString().toDouble()
        val nota2:Double=campoNota2.text.toString().toDouble()
        val nota3:Double=campoNota3.text.toString().toDouble()


        val ColorGanador = "#00FF00" // Verde
        val colorPerdedor = "#FF0000" // Rojo
        val colorResultado: Int


        val prom:Double=(nota1+nota2+nota3)/3
        println("el promedio es:"+prom)
        Log.i("salida","el promedio es $prom")

        var result=""


        if (prom >= 3.5) {
            Log.i("salida", "gano con su promedio de: $prom")
            result = "gano con su promedio de: $prom"
            colorResultado = Color.parseColor(ColorGanador)

        } else {
            Log.i("salida", "perdio la materia con un promedio de: $prom")
            result = "perdio la materia con un promedio de: $prom"
            colorResultado = Color.parseColor(colorPerdedor)
        }


        mensajeresult.text = "Hola $nombre, $result"
        mensajeresult.setTextColor(colorResultado)

        Toast.makeText(this,result,Toast.LENGTH_LONG).show()

    }
}