package com.example.hoqueiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    lateinit var BotaoLogin: Button
    lateinit var BotaoBack: Button
    lateinit var BotaoRegisto: Button
    lateinit var textEmailLogin: EditText
    lateinit var textPassLogin: EditText
    val mAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        textEmailLogin = findViewById(R.id.textEmailLogin)
        textPassLogin = findViewById(R.id.textPassLogin)
        BotaoLogin = findViewById(R.id.BotaoLogin)
        BotaoLogin.setOnClickListener {
            var email: String = textEmailLogin.text.toString()
            var pass: String = textPassLogin.text.toString()

            login(email, pass)
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(MainActivity::class.java)
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

    private fun login (email: String, pass: String) {

        if (!email.isEmpty() && !pass.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    executarOutraActivity(LoginOnMainActivity::class.java)
                    finish()
                } else {
                    Toast.makeText(this, "Login sem sucesso ", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Por favor preencha os campos!", Toast.LENGTH_SHORT).show()
        }
    }
}
