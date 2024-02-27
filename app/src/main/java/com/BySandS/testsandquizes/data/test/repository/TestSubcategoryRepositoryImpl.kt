package com.BySandS.testsandquizes.data.test.repository

import android.content.Context
import android.util.Log
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

/**
 * Вместо маперов лучше сделать Extantion
 */
class TestSubcategoryRepositoryImpl(private val subcategoryStorage: SubcategoryStorage) :
    TestSubcategoryRepository {

    override fun getAllSubcategories(param: GetCategoryParam): List<SubcategoryModel> {
        return mapToDomain(
            subcategoryStorage.getSubcategoriesAndStatistics(
                mapToStorage(param)
            )
        )
    }

    private fun mapToDomain(subcategoryModelDb: List<SubcategoryModelDb>): List<SubcategoryModel> {
        var listSubcategoryModel = ArrayList<SubcategoryModel>()
        subcategoryModelDb.forEach { it ->
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
        return listSubcategoryModel
    }
    private fun mapToStorage(param: GetCategoryParam): Long{
        return param.idCategory
    }
}