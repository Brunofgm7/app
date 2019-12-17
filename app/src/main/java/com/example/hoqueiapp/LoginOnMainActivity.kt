package com.example.hoqueiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginOnMainActivity : AppCompatActivity() {
    lateinit var BotaoClassificacao: Button
    lateinit var BotaoResultados: Button
    lateinit var BotaoPavilhoes: Button
    lateinit var BotaoDefConta: Button
    lateinit var BotaoLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_on_main)
        BotaoClassificacao = findViewById(R.id.BotaoClassificacao)
        BotaoResultados = findViewById(R.id.BotaoResultados)
        BotaoPavilhoes= findViewById(R.id.BotaoPavilhoes)
        BotaoDefConta = findViewById(R.id.BotaoDefConta)
        BotaoLogout = findViewById(R.id.BotaoLogout)
    }

}
