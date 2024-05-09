package com.example.dependencyinjectionroomdb.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
@Keep
data class ProductList(
    @SerializedName("category") val category: String?,
    @SerializedName("description") val description: String?,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("title") val title: String?,
)
