package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel

interface TestSubcategoryRepository {

    fun getAllSubcategories(idCategory: GetCategoryParam): List<SubcategoryModel>

}