package com.example.app_grupo_6

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ListaFragment : Fragment() {

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_lista,container,false)
        val detail1 : Button = fragmento.findViewById(R.id.btn_details1)
        val detail2 : Button = fragmento.findViewById(R.id.btn_details2)
        detail1.setOnClickListener(View.OnClickListener{
            detail1.context.startActivity(Intent(detail1.context,SellVistaActivity::class.java))

        })
        detail2.setOnClickListener(View.OnClickListener{
            detail2.context.startActivity(Intent(detail1.context,BuyActivity::class.java))

        })
        return fragmento
    }
}