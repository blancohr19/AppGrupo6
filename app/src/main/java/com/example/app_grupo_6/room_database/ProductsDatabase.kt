package com.example.app_grupo_6.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Products::class),version = 1)
abstract class ProductsDatabase : RoomDatabase(){
    abstract fun productsDao() : ProductsDAO
    companion object{
        @Volatile
        private  var INSTANCE : ProductsDatabase?=null
        fun getDatabase(context: Context):ProductsDatabase{
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    ProductsDatabase::class.java,"ProductsDatabase").build()
                INSTANCE = instance
                instance
            }
        }
    }
}