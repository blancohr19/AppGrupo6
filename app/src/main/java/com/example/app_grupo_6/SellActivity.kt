package com.example.app_grupo_6

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.app_grupo_6.room_database.Products
import com.example.app_grupo_6.room_database.ProductsDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

public final class SellActivity : Fragment() {

    var MyProductsNames: ArrayList<String> = ArrayList()
    var MyProductsDescriptions: ArrayList<String> = ArrayList()
    var MyProductsPrices: ArrayList<String> = ArrayList()
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter : RecyclerView.Adapter<MyProductListAdpter.MyViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.activity_sell,container,false)

        return fragmento
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fab : View = requireActivity().findViewById(R.id.fab)
        fab.setOnClickListener{view->
            val intent = Intent(activity,NewProductActivity::class.java)
            val recursiveScope=0
            startActivityForResult(intent,recursiveScope)
        }
        var info : Bundle = Bundle()
        info.putStringArrayList("names", MyProductsNames)
        info.putStringArrayList("descriptions", MyProductsDescriptions)
        info.putStringArrayList("prices", MyProductsPrices)
        listRecyclerView = requireView().findViewById(R.id.recyclerTodoList)
        myAdapter= MyProductListAdpter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter= myAdapter
        listRecyclerView.addItemDecoration(
            DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL)
        )
        updateList()
    }



    private fun updateList() {
        val db = ProductsDatabase.getDatabase(requireActivity())
        val productsDAO = db.productsDao()
        runBlocking {
            launch {
                var result = productsDAO.getAllTasks()
                var i = 0
                MyProductsNames.clear()
                MyProductsDescriptions.clear()
                MyProductsPrices.clear()
                while (i<result.size){
                    MyProductsNames.add(result[i].name.toString())
                    MyProductsDescriptions.add(result[i].description.toString())
                    MyProductsPrices.add(result[i].price.toString())
                    i++
                }
                myAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode==0){
            if(resultCode== Activity.RESULT_OK){
                updateList()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


}