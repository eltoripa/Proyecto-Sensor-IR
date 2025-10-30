package com.example.login

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class UsuarioActivity : AppCompatActivity() {
    private var conteo = 0
    private var sensorActivo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        val textoEstado = findViewById<TextView>(R.id.textoEstado)
        val textoConteo = findViewById<TextView>(R.id.textoConteo)
        val switchSensor = findViewById<Switch>(R.id.switchSensor)
        val botonSalir = findViewById<Button>(R.id.botonSalirUsuario)
        val botonBluetooth = findViewById<Button>(R.id.botonBluetooth) // 👈 NUEVO

        // Estado inicial
        textoEstado.text = "Estado del sensor: ACTIVO ✅"
        textoConteo.text = "Detecciones: $conteo"

        // Acción del botón Bluetooth (simulada)
        botonBluetooth.setOnClickListener {
            Toast.makeText(this, "Conectado al sensor IR (simulado)", Toast.LENGTH_SHORT).show()
        }

        // Control del switch
        switchSensor.isChecked = true
        switchSensor.setOnCheckedChangeListener { _, isChecked ->
            sensorActivo = isChecked
            textoEstado.text = if (isChecked) "Estado del sensor: ACTIVO ✅" else "Estado del sensor: APAGADO ❌"
        }

        // Conteo simulado al tocar el texto
        textoConteo.setOnClickListener {
            if (sensorActivo) {
                conteo++
                textoConteo.text = "Detecciones: $conteo"
                Toast.makeText(this, "Obstáculo detectado (mock)", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón de salida
        botonSalir.setOnClickListener {
            finish()
        }
    }
}
