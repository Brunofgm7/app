package com.example.hoqueiapp

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
        setContentView(R.layout.activity_login)
        gv = getApplication() as VariaveisGlobais
        BotaoLogin = findViewById(R.id.BotaoLogin)
        textUserLogin = findViewById(R.id.textUserLogin)
        // var a: String = textUserLogin.text.toString()
        textPassLogin = findViewById(R.id.textPassLogin)
        // var s: String = textPassLogin.text.toString()
        BotaoBack = findViewById(R.id.BotaoBack)

    }
}
