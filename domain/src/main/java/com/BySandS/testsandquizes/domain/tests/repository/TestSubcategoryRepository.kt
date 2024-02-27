package com.BySandS.testsandquizes.domain.tests.repository


interface TestSubcategoryRepository {

    fun getAllSubcategories(idCategory: com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam): List<com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel>

}