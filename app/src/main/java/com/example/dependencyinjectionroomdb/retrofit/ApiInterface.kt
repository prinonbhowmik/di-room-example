package com.example.dependencyinjectionroomdb.retrofit

import com.example.dependencyinjectionroomdb.models.ProductList
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("/products")
    suspend fun getProducts(): Response<List<ProductList>>
}