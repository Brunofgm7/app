package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
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
        supportActionBar?.hide()
        BotaoClassificacao = findViewById(R.id.BotaoClassificacao)
        BotaoClassificacao.setOnClickListener {
            executarOutraActivity(Class1DivActivity::class.java)
        }
        BotaoResultados = findViewById(R.id.BotaoResultados)
        BotaoResultados.setOnClickListener {
            executarOutraActivity(DivisoesActivity::class.java)
        }
        BotaoPavilhoes= findViewById(R.id.BotaoPavilhoes)
        BotaoPavilhoes.setOnClickListener {
            executarOutraActivity(PavilhoesActivity::class.java)
        }
        BotaoDefConta = findViewById(R.id.BotaoDefConta)
        BotaoDefConta.setOnClickListener {
            executarOutraActivity(DefContaActivity::class.java)
        }
        BotaoLogout = findViewById(R.id.BotaoLogout)
        BotaoLogout.setOnClickListener {
            mAuth.signOut()
            executarOutraActivity(MainActivity::class.java)
            finish()
        }
    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finishAffinity()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "BACK novamente para sair", Toast.LENGTH_SHORT).show()


        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
