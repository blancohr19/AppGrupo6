package com.example.app_grupo_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun OnLogin(botonLogin: View){
        val intento = Intent(this,LoginActivity::class.java)
        startActivity(intento)
    }
    fun OnRegister(botonRegis: View){
        val intento = Intent(this,RegisterActivity::class.java)
        startActivity(intento)
    }

}