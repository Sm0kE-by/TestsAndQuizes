package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel


interface TestSubcategoryRepository {

    fun getAllSubcategories(param: GetCategoryParam): List<SubcategoryModel>

}