package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_mudar_pass.*

class MudarPassActivity : AppCompatActivity() {


    lateinit var BotaoGuardar: Button
    lateinit var BotaoBack: Button
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mudar_pass)

        BotaoGuardar = findViewById(R.id.BotaoGuardar)
        BotaoGuardar.setOnClickListener {
            editarPass()
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(DefContaActivity::class.java)
        }
    }


    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }

    private fun editarPass(){

        val user = FirebaseAuth.getInstance().currentUser
        var novaPass = textNovaPass.text.toString()
        var repetirNovaPass = textRepetirNovaPass.text.toString()

        if (!novaPass.isEmpty() && !repetirNovaPass.isEmpty()) {
            if (novaPass == repetirNovaPass) {
                user!!.updatePassword(novaPass).addOnCompleteListener { task3 ->
                    if (task3.isSuccessful) {
                        Toast.makeText(this, "SUCESSO! Pass atualizada!", Toast.LENGTH_LONG).show()
                        executarOutraActivity(DefContaActivity::class.java)
                        finish()
                    } else {
                        Toast.makeText(this, "ERRO: Pass não atualizada", Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this, "ERRO: Pass não coincidem", Toast.LENGTH_LONG).show()
            }
        }

    }
}
