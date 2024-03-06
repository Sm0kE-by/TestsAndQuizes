package com.BySandS.testsandquizes.data.test.repository

import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryAndStatisticModelDb
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryParam
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

/**
 * Вместо маперов лучше сделать Extantion
 */
class TestSubcategoryRepositoryImpl(private val subcategoryStorage: SubcategoryStorage) :
    TestSubcategoryRepository {

    override fun getAllSubcategoriesAndStatistic(param: GetSubcategoryAndStatisticParam): List<SubcategoryAndStatisticModel> {
        return mapToDomainSubAndStat(
            subcategoryAndStatisticModelDb = subcategoryStorage.getSubcategoriesAndStatistics(
                idCategory = mapToStorageSubAndStat(param = param)
            )
        )
    }

    override fun getSubcategoryById(param: GetSubcategoryParam): SubcategoryModel {
        return mapToDomainSub(
            subcategoryModelDb = subcategoryStorage.getSubcategoryById(
                idSubcategory = mapToStorageSub(param = param)
            )
        )
    }

    private fun mapToDomainSubAndStat(subcategoryAndStatisticModelDb: List<SubcategoryAndStatisticModelDb>): List<SubcategoryAndStatisticModel> {
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

    private fun mapToDomainSub(subcategoryModelDb: SubcategoryModelDb): SubcategoryModel {
        return SubcategoryModel(
            id = subcategoryModelDb.id,
            subcategoryName = subcategoryModelDb.subcategoryName,
            subcategoryNameEng = subcategoryModelDb.subcategoryName,
            statisticId = subcategoryModelDb.statisticId,
            categoryId = subcategoryModelDb.categoryId,
            quantityOfQuestionsId = subcategoryModelDb.quantityOfQuestionsId,
            testResultId = subcategoryModelDb.testResultId
        )
    }

    private fun mapToStorageSubAndStat(param: GetSubcategoryAndStatisticParam): Long {
        return param.idCategory
    }

    private fun mapToStorageSub(param: GetSubcategoryParam): Long {
        return param.idSubcategory
    }
}