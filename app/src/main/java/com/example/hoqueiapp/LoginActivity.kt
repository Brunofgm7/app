package com.example.hoqueiapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import com.google.android.material.snackbar.Snackbar;
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    lateinit var BotaoLogin: Button
    lateinit var BotaoBack: Button
    lateinit var BotaoRegisto: Button
    lateinit var textEmailLogin: EditText
    lateinit var textPassLogin: EditText
    val mAuth = FirebaseAuth.getInstance()

    private val signInProviders =
        listOf(AuthUI.IdpConfig.EmailBuilder()
            .setAllowNewAccounts(true)
            .setRequireName(true)
            .build())

    private val RC_SIGN_IN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        BotaoSignIn.setOnClickListener {
            val intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(signInProviders)
                .build()
            startActivityForResult(intent, RC_SIGN_IN)
        }

        textEmailLogin = findViewById(R.id.textEmailLogin)
        textPassLogin = findViewById(R.id.textPassLogin)
        BotaoLogin = findViewById(R.id.BotaoLogin)
        BotaoLogin.setOnClickListener {
            var email: String = textEmailLogin.text.toString()
            var pass: String = textPassLogin.text.toString()

            //login(email, pass)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                val progressDialog = indeterminateProgressDialog("Setting up your account")
                startActivity(intentFor<LoginOnMainActivity>().newTask().clearTask())
                progressDialog.dismiss()
            }
            else if (resultCode == Activity.RESULT_CANCELED) {
                if (response == null) return

                when (response.error?.errorCode) {
                    ErrorCodes.NO_NETWORK ->
                        Snackbar.make(constraint_layout, "Sem ligação à rede", Snackbar.LENGTH_LONG).show()
                    ErrorCodes.UNKNOWN_ERROR ->
                        Snackbar.make(constraint_layout, "Erro desconhecido", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }




 /*   private fun login (email: String, pass: String) {


        if (!email.isEmpty() && !pass.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LoginOnMainActivity::class.java))
                    executarOutraActivity(LoginOnMainActivity::class.java)
                } else {
                    Toast.makeText(this, "Login sem sucesso ", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Por favor preencha os campos!", Toast.LENGTH_SHORT).show()
        }
    }*/
}
