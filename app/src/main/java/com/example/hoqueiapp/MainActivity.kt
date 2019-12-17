package com.example.hoqueiapp

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
        BotaoResultados = findViewById(R.id.BotaoResultados)
        BotaoPavilhoes = findViewById(R.id.BotaoPavilhoes)
        BotaoLogin = findViewById(R.id.BotaoLogin)
        BotaoLogin.setOnClickListener{
            executarOutraActivity(LoginActivity::class.java, "aChave", arrayListOf())
        }
        BotaoRegisto = findViewById(R.id.BotaoRegisto)
        BotaoRegisto.setOnClickListener {
            executarOutraActivity(RegistoActivity::class.java, "aChave", arrayListOf())
        }

    }
    private fun executarOutraActivity(outraActivity: Class<*>, chave: String, argsParaOutraActivity: ArrayList<String>) {
        val x = Intent(this, outraActivity)
        x.putStringArrayListExtra(chave, argsParaOutraActivity)
        startActivity(x)
    }
}
