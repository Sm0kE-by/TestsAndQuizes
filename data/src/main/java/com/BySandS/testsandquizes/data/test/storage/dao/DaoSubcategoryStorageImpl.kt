package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

class DaoSubcategoryStorageImpl(context: Context) : SubcategoryStorage {

    private val testsDaoRu = AppDatabase.getInstance(context).subcategoryDao()
    override fun getListSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryAndStatisticModelDb> {
        return testsDaoRu.getListSubcategoriesAndStatistics(idCategory = idCategory)
    }

    override fun getSubcategoriesAndStatistics(idSubcategory: Long): SubcategoryAndStatisticModelDb {
        return testsDaoRu.getSubcategoriesAndStatistics(idSubcategory = idSubcategory)
    }

    override fun getSubcategoryById(idSubcategory: Long): SubcategoryModelDb {
        return testsDaoRu.getSubcategoryById(idSubcategory = idSubcategory)
    }


}