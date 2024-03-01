package com.BySandS.testsandquizes.data.test.storage.dao

import android.content.Context
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb

class DaoSubcategoryStorage(context: Context) : SubcategoryStorage {

    private val testsDaoRu = AppDatabase.getInstance(context).subcategoryDao()
    override fun getSubcategoriesAndStatistics(idCategory: Long): List<SubcategoryModelDb> {
        return testsDaoRu.getSubcategoriesAndStatistics(idCategory = idCategory)
    }


}