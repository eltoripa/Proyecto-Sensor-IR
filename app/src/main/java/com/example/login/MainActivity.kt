package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // creamos las variables y las asignamos al front
        val etusuario = findViewById<EditText>(R.id.username)
        val etPassword = findViewById<EditText>(R.id.password)
        val etBoton = findViewById<Button>(R.id.botonLogin)

        etBoton.setOnClickListener {
            val Usuario = etusuario.text.toString()
            val contrasenia = etPassword.text.toString()

            if (Usuario.isEmpty() || contrasenia.isEmpty() ) {
                Toast.makeText(this, "Ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // validacion de usuario
            when {

                Usuario == "admin" && contrasenia == "1234" -> {
                    startActivity(Intent(this,AdminActivity::class.java))
                    Toast.makeText(this, "Bienvenido Administrador", Toast.LENGTH_SHORT).show()

                }

                Usuario == "user" && contrasenia == "abcd" -> {
                    startActivity(Intent(this, UsuarioActivity::class.java))
                    Toast.makeText(this, "Bienvenido Usuario", Toast.LENGTH_SHORT).show()

                }

                else -> {
                    Toast.makeText(this, "Usuario o contraseña invalida", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}