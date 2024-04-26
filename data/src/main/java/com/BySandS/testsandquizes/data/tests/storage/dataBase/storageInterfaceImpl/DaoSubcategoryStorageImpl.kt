package com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase
import com.BySandS.testsandquizes.data.tests.storage.dataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.SubcategoryModelForSubcategoryFragmentDb
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.SubcategoryStorage

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