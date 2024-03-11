package com.BySandS.testsandquizes.data.test.storage

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

interface SubcategoryStorage {
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelDb>
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb
}