package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel

interface SubcategoryStorage {

    fun getSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryModelDb>

}