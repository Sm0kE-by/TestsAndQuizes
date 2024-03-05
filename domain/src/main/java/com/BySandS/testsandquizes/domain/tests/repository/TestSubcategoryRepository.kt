package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryParam


interface TestSubcategoryRepository {

    fun getAllSubcategoriesAndStatistic(param: GetSubcategoryAndStatisticParam): List<SubcategoryAndStatisticModel>
    fun getSubcategoryById(param: GetSubcategoryParam): SubcategoryModel

}