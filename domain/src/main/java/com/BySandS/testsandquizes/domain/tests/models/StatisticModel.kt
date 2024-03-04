package com.BySandS.testsandquizes.domain.tests.models


data class StatisticModel(
    val id: Long,
    val nameSubcategory: String,
    var easy: Int,
    var norm: Int,
    var hard: Int,
)
