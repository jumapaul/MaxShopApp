package com.example.maxshop.data

import androidx.room.Entity

object Utils {
    val category = listOf(
        ProductCategory(id = 0, categoryTitle = "Electronics"),
        ProductCategory(id = 1, categoryTitle = "Jewelery"),
        ProductCategory(id = 2, categoryTitle = "Men's clothing"),
        ProductCategory(id = 3, categoryTitle = "Women's clothing"),
    )
}

@Entity("categories")
data class ProductCategory(
    val id: Int = -1,
    val categoryTitle: String
)
