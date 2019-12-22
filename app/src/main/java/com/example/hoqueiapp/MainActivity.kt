package com.example.hoqueiapp

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class VariaveisGlobais : Application() {
    // meter aqui as variaveis globais
}

class MainActivity : AppCompatActivity() {
    lateinit var BotaoClassificacao: Button
    lateinit var BotaoResultados: Button
    lateinit var BotaoPavilhoes: Button
    lateinit var BotaoLogin: Button
    lateinit var BotaoRegisto: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BotaoClassificacao = findViewById(R.id.BotaoClassificacao)
        BotaoClassificacao.setOnClickListener{
            executarOutraActivity(Class1DivActivity::class.java)
        }
        BotaoResultados = findViewById(R.id.BotaoResultados)
        BotaoResultados.setOnClickListener{
            executarOutraActivity(DivisoesActivity::class.java)
        }
        BotaoPavilhoes = findViewById(R.id.BotaoPavilhoes)
        BotaoPavilhoes.setOnClickListener{
            executarOutraActivity(PavilhoesActivity::class.java)
        }
        BotaoLogin = findViewById(R.id.BotaoLogin)
        BotaoLogin.setOnClickListener{
            executarOutraActivity(LoginActivity::class.java)
        }
        BotaoRegisto = findViewById(R.id.BotaoRegisto)
        BotaoRegisto.setOnClickListener {
            executarOutraActivity(RegistoActivity::class.java)
        }

    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }
}
