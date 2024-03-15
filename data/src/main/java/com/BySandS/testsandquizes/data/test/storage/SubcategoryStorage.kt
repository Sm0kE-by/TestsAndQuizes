package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelForSubcategoryFragmentDb

interface SubcategoryStorage {
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelForSubcategoryFragmentDb>
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb
}