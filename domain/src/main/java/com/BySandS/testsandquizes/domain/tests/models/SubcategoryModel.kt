package com.BySandS.testsandquizes.domain.tests.models

class SubcategoryModel(
    val id: Long,
    val subcategoryNameRu: String,
    val subcategoryNameEng: String,
    val statisticId: Long,
    val categoryId: Long,
    val quantityOfQuestionsId: Long,
    val testResultId: Long,
)