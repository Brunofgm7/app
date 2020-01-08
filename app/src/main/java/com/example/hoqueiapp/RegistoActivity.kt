package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_registo.*
import java.lang.Exception

class RegistoActivity : AppCompatActivity() {
    lateinit var BotaoRegisto: Button
    lateinit var BotaoBack: Button
    lateinit var BotaoJaTenhoConta: Button

    val mAuth = FirebaseAuth.getInstance()
    val Auth = FirebaseFirestore.getInstance().collection("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        BotaoRegisto = findViewById(R.id.BotaoRegisto)
        BotaoRegisto.setOnClickListener {
            registo()
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(MainActivity::class.java)
        }
        BotaoJaTenhoConta = findViewById(R.id.BotaoJaTenhoConta)
        BotaoJaTenhoConta.setOnClickListener {
            executarOutraActivity(LoginActivity::class.java)
        }

    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }

    private fun registo() {
        var nome = textUserRegisto.text.toString()
        var email = textEmailRegisto.text.toString()
        var pass = textPassRegisto.text.toString()

        if (!nome.isEmpty() && !email.isEmpty() && !pass.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Registo COM sucesso", Toast.LENGTH_SHORT).show()

                    createUser(nome, email, pass)

                    executarOutraActivity(LoginActivity::class.java)


                } else {
                    Toast.makeText(this, "Registo sem sucesso", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Por favor preencha os campos!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun InsertUser(user: User) {
        val userRef = Auth

        userRef.document().set(user).addOnCompleteListener {
            when {
                it.isSuccessful -> {
                    Toast.makeText(this, "Registo COM sucesso", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Registo sem sucesso", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun createUser(nome: String, email: String, pass: String) {
        val user = User()
        user.nome = nome
        user.email = email
        user.pass = pass

        InsertUser(user)
    }
}
