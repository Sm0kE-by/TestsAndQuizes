package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModelForSubcategoryFragment
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam


interface TestSubcategoryRepository {

    fun getListSubcategories(param: GetListSubcategoryParam): List<SubcategoryModelForSubcategoryFragment>
    fun getSubcategoryById(param: GetSubcategoryByIdParam): SubcategoryModel

}