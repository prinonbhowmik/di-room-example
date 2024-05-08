package com.example.dependencyinjectionroomdb.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ProductList(
    @SerializedName("category") val category: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("rating") val rating: Rating?,

)

@Keep
data class Rating(
    @SerializedName("count") val count: Int?,
    @SerializedName("rate") val rate: Double?
)