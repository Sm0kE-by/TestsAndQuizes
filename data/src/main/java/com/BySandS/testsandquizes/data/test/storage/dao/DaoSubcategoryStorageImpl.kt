package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelForSubcategoryFragmentDb

class DaoSubcategoryStorageImpl(context: Context) : SubcategoryStorage {

    private val testsDaoRu = AppDatabase.getInstance(context).subcategoryDao()
    override fun getListSubcategories(idCategory: Long): List<SubcategoryModelForSubcategoryFragmentDb> {
        return testsDaoRu.getListSubcategories(idCategory = idCategory)
    }

    override fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb {
        return testsDaoRu.getSubcategoryById(idSubcategory = idSubcategory)
    }

    override fun updateSubcategory(subcategory: SubcategoryDbEntity) {
        return testsDaoRu.updateSubcategory(subcategory = subcategory)
    }
}