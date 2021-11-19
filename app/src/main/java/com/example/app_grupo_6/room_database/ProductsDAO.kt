package com.example.app_grupo_6.room_database

import androidx.room.*


@Dao
interface ProductsDAO {
    @Query("select * from Products")
    suspend fun getAllTasks():List<Products>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task:Products):Long
    @Update
    suspend fun updateTask(task:Products)
    @Delete
    suspend fun deleteTask(task:Products)
}