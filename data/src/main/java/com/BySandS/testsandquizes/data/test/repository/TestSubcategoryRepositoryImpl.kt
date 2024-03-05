package com.BySandS.testsandquizes.data.test.repository

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

/**
 * Вместо маперов лучше сделать Extantion
 */
class TestSubcategoryRepositoryImpl(private val subcategoryStorage: SubcategoryStorage) :
    TestSubcategoryRepository {

    override fun getAllSubcategoriesAndStatistic(param: GetSubcategoryAndStatisticParam): List<SubcategoryAndStatisticModel> {
        return mapToDomain(
            subcategoryStorage.getSubcategoriesAndStatistics(
                idCategory = mapToStorage(param = param)
            )
        )
    }

    private fun mapToDomain(subcategoryAndStatisticModelDb: List<SubcategoryAndStatisticModelDb>): List<SubcategoryAndStatisticModel> {
        var listSubcategoryAndStatisticModel = ArrayList<SubcategoryAndStatisticModel>()
        subcategoryAndStatisticModelDb.forEach { it ->
            listSubcategoryAndStatisticModel.add(
                SubcategoryAndStatisticModel(
                    id = it.id,
                    typeName = it.subcategoryName,
                    subcategoryName = it.subcategoryName,
                    statisticEasyPercent = it.statisticEasy,
                    statisticNormPercent = it.statisticNorm,
                    statisticHardPercent = it.statisticHard
                )
            )
        }
        return listSubcategoryAndStatisticModel
    }

    private fun mapToStorage(param: GetSubcategoryAndStatisticParam): Long {
        return param.idCategory
    }
}