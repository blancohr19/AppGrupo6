package com.example.app_grupo_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view,ListaFragment::class.java,null,"todo")
                .commit()
        }
    }
}