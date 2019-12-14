package com.example.hoqueiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Class1DivActivity : AppCompatActivity() {
    lateinit var ButtonBack: Button
    lateinit var gv: VariaveisGlobais


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class1_div)
        gv = getApplication() as VariaveisGlobais
        ButtonBack = findViewById(R.id.BotaoBack)
    }
}
