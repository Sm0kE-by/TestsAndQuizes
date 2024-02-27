package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

interface SubcategoryStorage {
    fun getSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryModelDb>

}