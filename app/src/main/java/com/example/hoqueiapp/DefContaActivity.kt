package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class DefContaActivity : AppCompatActivity() {
    lateinit var BotaoEditarEmail: Button
    lateinit var BotaoMudarPass: Button
    lateinit var BotaoBack: Button
    lateinit var viewNome: TextView
    var viewEmail = null
    val AuthCU : FirebaseAuth = FirebaseAuth.getInstance()
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_def_conta)

        //FirebaseUser currentUser = mAuth.getCurrentUser();

        //UpdateCurrentUser()
      //    viewNome = findViewById(R.id.viewNome)
        val UC = FirebaseAuth.getInstance().currentUser
//        viewEmail = findViewById(R.id.viewEmail)
        //viewEmail.text = String.format(UC!!.email.toString())

        BotaoEditarEmail = findViewById(R.id.BotaoEditarEmail)
        BotaoEditarEmail.setOnClickListener {
            executarOutraActivity(MudarEmailActivity::class.java)
        }
        BotaoMudarPass = findViewById(R.id.BotaoMudarPass)
        BotaoMudarPass.setOnClickListener {
            executarOutraActivity(MudarPassActivity::class.java)
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(LoginOnMainActivity::class.java)
        }
    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }
}
