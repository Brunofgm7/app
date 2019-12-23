package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class LoginOnMainActivity : AppCompatActivity() {
    lateinit var BotaoClassificacao: Button
    lateinit var BotaoResultados: Button
    lateinit var BotaoPavilhoes: Button
    lateinit var BotaoDefConta: Button
    lateinit var BotaoLogout: Button
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_on_main)
        BotaoClassificacao = findViewById(R.id.BotaoClassificacao)
        BotaoResultados = findViewById(R.id.BotaoResultados)
        BotaoResultados.setOnClickListener {
            executarOutraActivity(DivisoesActivity::class.java)
        }
        BotaoPavilhoes= findViewById(R.id.BotaoPavilhoes)
        BotaoDefConta = findViewById(R.id.BotaoDefConta)
        BotaoDefConta.setOnClickListener {
            executarOutraActivity(DefContaActivity::class.java)
        }
        BotaoLogout = findViewById(R.id.BotaoLogout)
        BotaoLogout.setOnClickListener {
            logout()
            executarOutraActivity(MainActivity::class.java)
        }
    }

    private fun logout ()  {
        mAuth.signOut()
    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }
}
