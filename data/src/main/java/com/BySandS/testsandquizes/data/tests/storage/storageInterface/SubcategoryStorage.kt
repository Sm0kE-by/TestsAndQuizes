package com.BySandS.testsandquizes.data.tests.storage.storageInterface

import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.SubcategoryModelForSubcategoryFragmentDb

interface SubcategoryStorage {
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelForSubcategoryFragmentDb>
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb
    fun updateSubcategory(subcategory: SubcategoryDbEntity)
}