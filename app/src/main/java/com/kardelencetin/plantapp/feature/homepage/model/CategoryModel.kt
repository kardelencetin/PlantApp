package com.kardelencetin.plantapp.feature.homepage.model

data class CategoryResponse(
    val data: List<Category>,
    val meta: Meta
)

data class Category(
    val id: Int,
    val name: String,
    val createdAt: String,
    val updatedAt: String,
    val title: String,
    val rank: Int,
    val image: Image
)

data class Image(
    val id: Int,
    val name: String,
    val width: Int,
    val height: Int,
    val size: Double,
    val url: String
)

data class Meta(
    val pagination: Pagination
)

data class Pagination(
    val page: Int,
    val pageSize: Int,
    val pageCount: Int,
    val total: Int
)