package com.example.hse24.domain.models

import com.example.hse24.data.models.CategoryDto

data class SimpleCategory (val categoryId: Int,
                           val displayName: String)

fun CategoryDto.toSimpleList(): SimpleCategory{
    return SimpleCategory(categoryId, displayName)
}