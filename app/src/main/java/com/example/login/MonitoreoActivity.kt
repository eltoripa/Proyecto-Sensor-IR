package com.example.login

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MonitoreoActivity : AppCompatActivity() {

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoreo)

        val textoConteo = findViewById<TextView>(R.id.textoConteo)
        val botonActualizar = findViewById<Button>(R.id.botonActualizar)
        val botonSalir = findViewById<Button>(R.id.botonSalir)

        textoConteo.text = "Personas detectadas: $contador"

        botonActualizar.setOnClickListener {
            contador++
            textoConteo.text = "Personas detectadas: $contador"
            Toast.makeText(this, "Dato actualizado (mock)", Toast.LENGTH_SHORT).show()
        }

        botonSalir.setOnClickListener {
            finish()
        }
    }
}
