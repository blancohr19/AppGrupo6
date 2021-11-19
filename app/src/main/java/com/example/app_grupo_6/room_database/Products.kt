package com.example.app_grupo_6.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Products (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name : String?,
    val description : String?,
    val price: String?
        )
