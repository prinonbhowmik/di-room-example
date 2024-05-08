package com.example.dependencyinjectionroomdb.repository

import com.example.dependencyinjectionroomdb.base.BaseRepository
import com.example.dependencyinjectionroomdb.retrofit.ApiInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiInterface: ApiInterface) : BaseRepository() {

    suspend fun getProducts() = safeApiCall {
        apiInterface.getProducts()
    }
}