package com.BySandS.testsandquizes.domain.tests.models

class SubcategoryModel(
    val id: Long,
    val name: String,
    val categoryId: Long,
    val quantityOfQuestionsId: Long,
    var statisticEasy: Int,
    var statisticNorm: Int,
    var statisticHard: Int,
    val linkToBackground: String,
    val linkToIcon: String
)