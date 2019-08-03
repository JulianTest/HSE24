package com.example.hse24.data.models

import com.google.gson.annotations.SerializedName

data class CategoryResultDto(
    @SerializedName("children")
    val children: List<CategoryDto>
)