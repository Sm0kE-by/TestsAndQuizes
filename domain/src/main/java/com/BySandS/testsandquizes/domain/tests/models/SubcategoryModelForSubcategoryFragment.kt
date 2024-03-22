package com.BySandS.testsandquizes.domain.tests.models

class SubcategoryModelForSubcategoryFragment(
    val id: Long,
    val name: String,
    var statisticEasy: Int,
    var statisticNorm: Int,
    var statisticHard: Int,
    var statisticVeryHard: Int,
    val linkToIcon: String
)