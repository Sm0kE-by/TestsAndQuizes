package com.BySandS.testsandquizes.domain.tests.models


data class StatisticModel(
    val id: Long,
    val nameSubcategory: String,
    val easy: Int,
    val norm: Int,
    val hard: Int,
)
