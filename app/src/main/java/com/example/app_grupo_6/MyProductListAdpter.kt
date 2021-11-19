package com.example.app_grupo_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MyProductListAdpter (context : AppCompatActivity, val info: Bundle)
    : RecyclerView.Adapter<MyProductListAdpter.MyViewHolder>(){
        class MyViewHolder(val layout : View): RecyclerView.ViewHolder(layout)
        private  var context : AppCompatActivity = context
        var  MyProductsNames : ArrayList<String> = info.getStringArrayList("names") as ArrayList<String>
        var  MyProductsDescriptions : ArrayList<String> = info.getStringArrayList("descriptions") as ArrayList<String>
        var  MyProductsPrices : ArrayList<String> = info.getStringArrayList("prices") as ArrayList<String>

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            var layout = LayoutInflater.from(parent.context).inflate(R.layout.product_list_items,parent,false)
            return MyViewHolder(layout)
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var textViewName= holder.layout.findViewById<TextView>(R.id.textViewName)
        textViewName.text=MyProductsNames[position]
        var textViewDescription= holder.layout.findViewById<TextView>(R.id.textViewDescription)
        textViewDescription.text=MyProductsDescriptions[position]
        holder.layout.setOnClickListener{
            Toast.makeText(holder.itemView.context,textViewName.text, Toast.LENGTH_LONG).show()
            val datos = Bundle()
            datos.putString("tarea",textViewName.text as String)
            datos.putString("hora",textViewDescription.text as String)
            datos.putString("lugar",MyProductsPrices[position])
            context.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view,DetailsFragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()
        }
    }

    override fun getItemCount(): Int {
        return  MyProductsNames.size
    }
}