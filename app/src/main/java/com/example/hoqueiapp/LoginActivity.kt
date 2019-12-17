package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var BotaoLogin: Button
    lateinit var BotaoBack: Button
    lateinit var textUserLogin: EditText
    lateinit var textPassLogin: EditText
    lateinit var gv: VariaveisGlobais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gv = getApplication() as VariaveisGlobais
        setContentView(R.layout.activity_login)
        BotaoLogin = findViewById(R.id.BotaoLogin)
        textUserLogin = findViewById(R.id.textUserLogin)
        // var a: String = textUserLogin.text.toString()
        textPassLogin = findViewById(R.id.textPassLogin)
        // var s: String = textPassLogin.text.toString()
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(MainActivity::class.java)
        }

    }
    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }
}
