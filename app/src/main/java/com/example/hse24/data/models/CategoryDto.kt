package com.example.hse24.data.models

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("categoryId")
    val categoryId: Int,
    @SerializedName("children")
    val children: List<CategoryDto>,
    @SerializedName("displayName")
    val displayName: String

)



