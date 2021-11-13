package com.example.app_grupo_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
        private var txtName : EditText ?=null
        private var txtLastname : EditText?=null
        private var txtNit : EditText?=null
        private var txtEmail : EditText?=null
        private var txtPhone : EditText?=null
        private var txtPass : EditText?=null
        private var check : CheckBox?=null

        private val name_pattern : Pattern = Pattern.compile("[a-zA-Z]*")
        private val pass_patter : Pattern = Pattern.compile("^"
                +"(?=.*[0-9])"
                +"(?=.*[a-z])"
                +"(?=.*[A-Z])"
                +"(?=.*[@#$.^+=&%])"
                +"(?=\\S+$)"
                +".{8,}"
                +"$"
        )
    private val email_pattern : Pattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtName = findViewById(R.id.txtName)
        txtLastname = findViewById(R.id.txtLastname)
        txtNit = findViewById(R.id.txtNit)
        txtEmail = findViewById(R.id.txtEmail)
        txtPhone = findViewById(R.id.txtPhone)
        txtPass = findViewById(R.id.txtPass)
        check = findViewById(R.id.inCheck)
    }

    fun register(btnRegister : View){
        if(pasaValidaciones()){
            val redirectLogin = Intent(this,LoginActivity::class.java)
            startActivity(redirectLogin)
        }else{
            //mensaje en pantalla
            Toast.makeText(this,"Campos vacios",Toast.LENGTH_LONG).show()
        }
    }

    //para indicar que devuelve un elemento se pone : y el tipo del objeto
    fun pasaValidaciones() : Boolean{
        var valido = true

        // !! indica que primero valida que no sea null
        // Con el dialogo de confirmación hace el cambio con intent si confirman
        if(TextUtils.isEmpty(txtName!!.text.toString())){
            //esta vacio
            valido=false
            //Si el campo de texto está dentro de un inputlayout se puede usar esto para que muestre en rojo el el error
            txtName!!.error=""
        }else{
            var name : String = txtName!!.text.toString()
            name = name.replace(" ","")
            if(!name_pattern.matcher(name).matches()){
                valido=false;

                Toast.makeText(this,"Nombre incorrecto",Toast.LENGTH_SHORT).show()
            }
        }
        if(TextUtils.isEmpty(txtLastname!!.text.toString())){
            //esta vacio
            valido=false
            txtLastname!!.error=""
        }else{
            var lastn : String = txtLastname!!.text.toString()
            lastn = lastn.replace(" ","")
            if(!name_pattern.matcher(lastn).matches()){
                valido=false;
                Toast.makeText(this,"Apellidos incorrectos",Toast.LENGTH_SHORT).show()
            }
        }
        if(TextUtils.isEmpty(txtEmail!!.text.toString())){
            //esta vacio
            valido=false
            txtEmail!!.error=""
        }else{
            var email : String = txtEmail!!.text.toString()

            if(!email_pattern.matcher(email).matches()){
                valido=false;
                Toast.makeText(this,"Email incorrecto",Toast.LENGTH_SHORT).show()
            }
        }
        if(TextUtils.isEmpty(txtNit!!.text.toString())){
            //esta vacio
            valido=false
            txtNit!!.error=""
        }
        if(TextUtils.isEmpty(txtPhone!!.text.toString())){
            //esta vacio
            valido=false
            txtPhone!!.error=""
        }
        if(TextUtils.isEmpty(txtPass!!.text.toString())){
            //esta vacio
            valido=false

            txtPass!!.error=""
        }else{
            var pass : String = txtPass!!.text.toString()
            if(!pass_patter.matcher(pass).matches()){
                valido=false;
                txtPass!!.error="No cumple con el formato"
                Toast.makeText(this,"Revise Formato del password",Toast.LENGTH_SHORT).show()
            }
        }


        if(!check!!.isChecked){
            valido=false;
            Toast.makeText(this,"Aceptar las politicas",Toast.LENGTH_SHORT).show()
        }

        return valido
    }
}