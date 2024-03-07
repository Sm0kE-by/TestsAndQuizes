package com.BySandS.testsandquizes.domain.tests.repository

import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryParam


interface TestSubcategoryRepository {

    fun getAllSubcategoriesAndStatistic(param: GetListSubcategoryAndStatisticParam): List<SubcategoryAndStatisticModel>
    fun getSubcategoriesAndStatisticById(param: GetSubcategoryAndStatisticParam): SubcategoryAndStatisticModel
    fun getSubcategoryById(param: GetSubcategoryParam): SubcategoryModel

}