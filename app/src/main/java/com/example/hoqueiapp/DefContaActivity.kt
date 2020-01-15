package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.auth.data.remote.EmailSignInHandler
import com.firebase.ui.auth.ui.email.EmailActivity
import com.google.firebase.auth.EmailAuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.auth.User
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.find
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_def_conta.*
import org.jetbrains.anko.email


class DefContaActivity : AppCompatActivity() {

    lateinit var viewEmail: TextView
    lateinit var BotaoEditarEmail: Button
    lateinit var BotaoMudarPass: Button
    lateinit var BotaoBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_def_conta)


        BotaoEditarEmail = findViewById(R.id.BotaoEditarEmail)
        BotaoEditarEmail.setOnClickListener {
            executarOutraActivity(MudarEmailActivity::class.java)
            finish()
        }
        BotaoMudarPass = findViewById(R.id.BotaoMudarPass)
        BotaoMudarPass.setOnClickListener {
            executarOutraActivity(MudarPassActivity::class.java)
        }
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(LoginOnMainActivity::class.java)
        }

        viewEmail = findViewById(R.id.viewEmail)

        getdata()

    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }

    private fun getdata() {
        val user = FirebaseAuth.getInstance().currentUser
        val Auth = FirebaseFirestore.getInstance().collection("Users")
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    viewEmail.text = user!!.email
                }
            }
    }
}
