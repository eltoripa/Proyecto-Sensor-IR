package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AdminActivity : AppCompatActivity() {

    private var sensoresActivos = 3
    private var usuariosConectados = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val textoEstadoSistema = findViewById<TextView>(R.id.textoEstadoSistema)
        val textoLogs = findViewById<TextView>(R.id.textoLogs)
        val botonMonitoreo = findViewById<Button>(R.id.botonMonitoreo)
        val botonReiniciar = findViewById<Button>(R.id.botonReiniciar)
        val botonSalir = findViewById<Button>(R.id.botonSalirAdmin)

        // Estado inicial
        textoEstadoSistema.text =
            "Sistema en línea\nSensores activos: $sensoresActivos\nUsuarios conectados: $usuariosConectados"

        // Botón: ver monitoreo general
        botonMonitoreo.setOnClickListener {
            val intent = Intent(this, MonitoreoActivity::class.java)
            startActivity(intent)
        }

        // Botón: reiniciar sistema (simulado)
        botonReiniciar.setOnClickListener {
            sensoresActivos = (1..5).random()
            usuariosConectados = (1..4).random()
            textoEstadoSistema.text =
                "Sistema reiniciado\nSensores activos: $sensoresActivos\nUsuarios conectados: $usuariosConectados"
            textoLogs.text =
                "Registro de eventos:\n- Sistema reiniciado correctamente\n- Nueva actualización: ${System.currentTimeMillis()}"
            Toast.makeText(this, "Sistema reiniciado (simulado)", Toast.LENGTH_SHORT).show()
        }

        // Botón: cerrar sesión
        botonSalir.setOnClickListener {
            finish()
        }
    }
}
