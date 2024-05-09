package com.example.dependencyinjectionroomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dependencyinjectionroomdb.models.ProductList

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<ProductList>)

    @Query("SELECT * FROM Products")
    suspend fun getProducts() : List<ProductList>

}