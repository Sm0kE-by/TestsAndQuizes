package com.BySandS.testsandquizes.data.storage.tests.dataBase.dao

import android.content.Context
import com.BySandS.testsandquizes.data.storage.tests.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.storage.tests.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.SubcategoryStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.SubcategoryModelForSubcategoryFragmentDb

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