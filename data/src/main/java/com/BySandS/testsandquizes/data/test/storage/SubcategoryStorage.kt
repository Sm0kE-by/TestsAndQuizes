package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb

interface SubcategoryStorage {
    fun getSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryAndStatisticModelDb>

}