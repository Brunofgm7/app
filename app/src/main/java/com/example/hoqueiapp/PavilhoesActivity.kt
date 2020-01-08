package com.example.hoqueiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.net.Uri

class PavilhoesActivity : AppCompatActivity() {
    lateinit var BotaoBack: Button
    lateinit var BotaoPavHCM: Button
    lateinit var BotaoPavFCP: Button

    val hcm = "geo:0,0?q=Pavilhão Bernardino Coutinho"
    val fcp = "geo:0,0?q=Dragão Arena"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pavilhoes)
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            executarOutraActivity(MainActivity::class.java)
        }
        BotaoPavHCM = findViewById(R.id.BotaoPavHCM)
        BotaoPavHCM.setOnClickListener {
            val uriMap = Uri.parse(hcm)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavFCP = findViewById(R.id.BotaoPavFCP)
        BotaoPavFCP.setOnClickListener {
            val uriMap = Uri.parse(fcp)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }

    }

    private fun executarOutraActivity(outraActivity: Class<*>) {
        val x = Intent(this, outraActivity)
        startActivity(x)
    }
}
