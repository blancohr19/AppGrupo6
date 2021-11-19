package com.example.app_grupo_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.app_grupo_6.room_database.Products
import com.example.app_grupo_6.room_database.ProductsDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewProductActivity : AppCompatActivity() {

    lateinit var edit_text_name: EditText
    lateinit var edit_text_description: EditText
    lateinit var edit_text_price: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product)
        edit_text_name = findViewById(R.id.edt_name)
        edit_text_description = findViewById(R.id.edt_des)
        edit_text_price = findViewById(R.id.edt_price)
    }

    fun onSave(view:android.view.View){
        var name : String = edit_text_name.text.toString()
        var description : String = edit_text_description.text.toString()
        var price : String = edit_text_price.text.toString()
        val db = ProductsDatabase.getDatabase(this)
        val productsDAO = db.productsDao()
        val product = Products(0,name,description,price)
        runBlocking {
            launch {
                var result = productsDAO.insertTask(product)
                if (result!=1L){
                    setResult(RESULT_OK)
                    finish()
                }
            } }
    }


}