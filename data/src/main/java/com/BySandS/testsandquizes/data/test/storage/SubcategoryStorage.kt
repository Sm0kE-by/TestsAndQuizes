package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryParam

interface SubcategoryStorage {
    fun getSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryAndStatisticModelDb>
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb
}