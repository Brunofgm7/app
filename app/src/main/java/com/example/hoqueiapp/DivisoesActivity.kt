package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DivisoesActivity : AppCompatActivity() {
    lateinit var Botao1Div: Button
    lateinit var Botao2DivN: Button
    lateinit var Botao2DivC: Button
    lateinit var Botao2DivS: Button
    lateinit var Botao3DivN: Button
    lateinit var Botao3DivC: Button
    lateinit var Botao3DivS: Button
    lateinit var BotaoBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divisoes)
        supportActionBar?.hide()
        Botao1Div = findViewById(R.id.Botao1Div)
        Botao1Div.setOnClickListener {
            executarOutraActivity(ChatActivity::class.java)
        }
        Botao2DivN = findViewById(R.id.Botao2DivN)
        Botao2DivN.setOnClickListener {
            Toast.makeText(this, "Esta divisão não está disponível", Toast.LENGTH_SHORT).show()
        }
        Botao2DivC = findViewById(R.id.Botao2DivC)
        Botao2DivC.setOnClickListener {
            Toast.makeText(this, "Esta divisão não está disponível", Toast.LENGTH_SHORT).show()
        }
        Botao2DivS = findViewById(R.id.Botao2DivS)
        Botao2DivS.setOnClickListener {
            Toast.makeText(this, "Esta divisão não está disponível", Toast.LENGTH_SHORT).show()
        }
        Botao3DivN = findViewById(R.id.Botao3DivN)
        Botao3DivN.setOnClickListener {
            Toast.makeText(this, "Esta divisão não está disponível", Toast.LENGTH_SHORT).show()
        }
        Botao3DivC = findViewById(R.id.Botao3DivC)
        Botao3DivC.setOnClickListener {
            Toast.makeText(this, "Esta divisão não está disponível", Toast.LENGTH_SHORT).show()
        }
        Botao3DivS = findViewById(R.id.Botao3DivS)
        Botao3DivS.setOnClickListener {
            Toast.makeText(this, "Esta divisão não está disponível", Toast.LENGTH_SHORT).show()
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            finish()
        }
    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }
}