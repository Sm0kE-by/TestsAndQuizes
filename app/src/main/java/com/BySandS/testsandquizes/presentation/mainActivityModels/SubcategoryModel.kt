package com.BySandS.testsandquizes.presentation.mainActivityModels

data class CategoryModel(
    val type: String,
    val name: String,
    val easyPercent: Int,
    val normPercent: Int,
    val hardPercent: Int,
    )