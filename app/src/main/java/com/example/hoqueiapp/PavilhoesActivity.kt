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
    lateinit var BotaoPavOCB: Button
    lateinit var BotaoPavUDO: Button
    lateinit var BotaoPavSCP: Button
    lateinit var BotaoPavSLB: Button
    lateinit var BotaoPavHCT: Button
    lateinit var BotaoPavRAHC: Button
    lateinit var BotaoPavADV: Button
    lateinit var BotaoPavHCB: Button
    lateinit var BotaoPavADS: Button
    lateinit var BotaoPavAJV: Button
    lateinit var BotaoPavCDPA: Button
    lateinit var BotaoPavHCOT: Button
    lateinit var BotaoPavAEFD: Button

    val hcm = "geo:0,0?q=Pavilhão Bernardino Coutinho"
    val fcp = "geo:0,0?q=Dragão Arena"
    val ocb = "geo:0,0?q=Pavilhão Municipal de Barcelos"
    val udo = "geo:0,0?q=União Desportiva Oliveirense"
    val scp = "geo:0,0?q=Pavilhão João Rocha"
    val slb = "geo:0,0?q=Pavilhão da Luz Nº1"
    val hct = "geo:0,0?q=Hóquei Clube de Turquel"
    val rahc = "geo:0,0?q=Riba d'Ave Hóquei Clube"
    val adv = "geo:0,0?q=Pavilhão Municipal de Valongo"
    val hcb = "geo:0,0?q=Pavilhão das Goladas"
    val ads = "geo:0,0?q=Pavilhão Associação Desportiva Sanjoanense"
    val ajv = "geo:0,0?q=Associação Juventude De Viana"
    val cdpa = "geo:0,0?q=Clube Desportivo Paço de Arcos"
    val hcot = "geo:0,0?q=Hoquei Clube Os Tigres de Almeirim"
    val aefd = "geo:0,0?q=Fisica Torres Vedras"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pavilhoes)
        supportActionBar?.hide()
        BotaoBack = findViewById(R.id.BotaoBack)
        BotaoBack.setOnClickListener {
            finish()
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
        BotaoPavOCB = findViewById(R.id.BotaoPavOCB)
        BotaoPavOCB.setOnClickListener {
            val uriMap = Uri.parse(ocb)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavUDO = findViewById(R.id.BotaoPavUDO)
        BotaoPavUDO.setOnClickListener {
            val uriMap = Uri.parse(udo)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavSCP = findViewById(R.id.BotaoPavSCP)
        BotaoPavSCP.setOnClickListener {
            val uriMap = Uri.parse(scp)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavSLB = findViewById(R.id.BotaoPavSLB)
        BotaoPavSLB.setOnClickListener {
            val uriMap = Uri.parse(slb)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavHCT = findViewById(R.id.BotaoPavHCT)
        BotaoPavHCT.setOnClickListener {
            val uriMap = Uri.parse(hct)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavRAHC = findViewById(R.id.BotaoPavRAHC)
        BotaoPavRAHC.setOnClickListener {
            val uriMap = Uri.parse(rahc)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavADV = findViewById(R.id.BotaoPavADV)
        BotaoPavADV.setOnClickListener {
            val uriMap = Uri.parse(adv)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavHCB = findViewById(R.id.BotaoPavHCB)
        BotaoPavHCB.setOnClickListener {
            val uriMap = Uri.parse(hcb)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavADS = findViewById(R.id.BotaoPavADS)
        BotaoPavADS.setOnClickListener {
            val uriMap = Uri.parse(ads)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavAJV = findViewById(R.id.BotaoPavAJV)
        BotaoPavAJV.setOnClickListener {
            val uriMap = Uri.parse(ajv)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavCDPA = findViewById(R.id.BotaoPavCDPA)
        BotaoPavCDPA.setOnClickListener {
            val uriMap = Uri.parse(cdpa)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavHCOT = findViewById(R.id.BotaoPavHCOT)
        BotaoPavHCOT.setOnClickListener {
            val uriMap = Uri.parse(hcot)
            val intent = Intent(Intent.ACTION_VIEW,uriMap)
            intent.setPackage("com.google.android.apps.maps")
            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }
        }
        BotaoPavAEFD = findViewById(R.id.BotaoPavAEFD)
        BotaoPavAEFD.setOnClickListener {
            val uriMap = Uri.parse(aefd)
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
