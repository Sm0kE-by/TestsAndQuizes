package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

private const val TAG = "AAA"

class TestSubcategoryRepositoryImpl(context: Context) : TestSubcategoryRepository {

    private val testsDaoRu = AppDatabase.getInstance(context).testsSubcategoryDaoRu()

    override fun getAllSubcategories(param: GetCategoryParam): List<SubcategoryModel> {
        val list1 = testsDaoRu.getSubcategoriesAndStatistics(idCategory = param.idCategory)
        Log.e(TAG, "$list1\n")
        var listSubcategoryModel = ArrayList<SubcategoryModel>()
        Log.e(TAG, "$listSubcategoryModel")
        list1.forEach { it ->
            listSubcategoryModel.add(
                SubcategoryModel(
                    id = it.id,
                    typeName = it.subcategoryName,
                    subcategoryName = it.subcategoryName,
                    statisticEasyPercent = it.statisticEasy,
                    statisticNormPercent = it.statisticNorm,
                    statisticHardPercent = it.statisticHard
                )
            )
        }
        Log.e(TAG, "$listSubcategoryModel")
        val list2: List<SubcategoryModel> = listSubcategoryModel
        Log.e(TAG, "${list2.size}")
        return list2
    }
}