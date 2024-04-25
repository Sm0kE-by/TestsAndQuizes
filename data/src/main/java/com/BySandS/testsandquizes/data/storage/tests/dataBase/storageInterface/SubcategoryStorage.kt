package com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.SubcategoryModelForSubcategoryFragmentDb

interface SubcategoryStorage {
    fun getListSubcategories(idCategory: Long): List<SubcategoryModelForSubcategoryFragmentDb>
    fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb
    fun updateSubcategory(subcategory: SubcategoryDbEntity)
}