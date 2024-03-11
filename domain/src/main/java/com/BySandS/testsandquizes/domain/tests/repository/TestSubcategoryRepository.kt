package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategory
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam


interface TestSubcategoryRepository {

    fun getListSubcategories(param: GetListSubcategory): List<SubcategoryModel>
    fun getSubcategoryById(param: GetSubcategoryByIdParam): SubcategoryModel

}