package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_mudar_email.*

class MudarEmailActivity : AppCompatActivity() {

    lateinit var viewEmailAtual: TextView
    lateinit var textNovoEmail: EditText
    lateinit var BotaoGuardar: Button
    lateinit var BotaoBack: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mudar_email)

        viewEmailAtual = findViewById(R.id.viewEmailAtual)
        textNovoEmail = findViewById(R.id.textNovoEmail)
        BotaoGuardar = findViewById(R.id.BotaoGuardar)
        BotaoGuardar.setOnClickListener {
            editarEmail()
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(DefContaActivity::class.java)
        }

        getdata()

    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }

    private fun editarEmail() {

        val user = FirebaseAuth.getInstance().currentUser

        var novoEmail = textNovoEmail.text.toString()

        if (user != null) {
            if (!novoEmail.isEmpty()) {
                user?.updateEmail(novoEmail).addOnCompleteListener { task2 ->
                    if (task2.isSuccessful) {
                        val utilizador = HashMap<String, Any>()
                        utilizador["email"] = novoEmail

                        FirebaseFirestore.getInstance().collection("Users").document(user.uid).update(utilizador)

                        Toast.makeText(this, "SUCESSO! Email atualizado!", Toast.LENGTH_LONG).show()
                        executarOutraActivity(DefContaActivity::class.java)
                        finish()
                    } else {
                        Toast.makeText(this, "ERRO: Email não atualizado", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun getdata() {
        val user = FirebaseAuth.getInstance().currentUser
        val Auth = FirebaseFirestore.getInstance().collection("Users")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    viewEmailAtual.text = user!!.email
                }
            }
    }

}
