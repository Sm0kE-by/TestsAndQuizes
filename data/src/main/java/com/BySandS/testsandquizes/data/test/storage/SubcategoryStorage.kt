package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

interface SubcategoryStorage {
    fun getListSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryAndStatisticModelDb>
    fun getSubcategoriesAndStatistics(idSubcategory: Long): SubcategoryAndStatisticModelDb
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb
}