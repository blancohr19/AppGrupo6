package com.example.app_grupo_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var edtEmail : EditText?=null
    private var edtPass : EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail=findViewById(R.id.editTextCorreo)
        edtPass=findViewById(R.id.edtPassL)
    }

    fun OnLoginI(botonLoginI:View){
        if(edtEmail!!.text.toString()=="correo@ejemplo.com"){
            if(edtPass!!.text.toString()=="Prueba@2"){
                    val intento_i = Intent(this,InicioActivity::class.java)
                    startActivity(intento_i)
                }else{
                    Toast.makeText(this,"Error Contraseña",Toast.LENGTH_SHORT).show()
            }
            }else{
            Toast.makeText(this,"Error Correo",Toast.LENGTH_SHORT).show()
        }
        }
    }
