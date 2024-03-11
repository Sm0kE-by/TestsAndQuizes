package com.BySandS.testsandquizes.data.test.repository

import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategory
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

/**
 * Вместо маперов лучше сделать Extantion
 */
class TestSubcategoryRepositoryImpl(private val subcategoryStorage: SubcategoryStorage) :
    TestSubcategoryRepository {

    override fun getListSubcategories(param: GetListSubcategory): List<SubcategoryModel> {
        return mapToDomainListSub(
            subcategoryModelDb = subcategoryStorage.getListSubcategories(
                idCategory = mapToStorageListSub(param = param)
            )
        )
    }

    override fun getSubcategoryById(param: GetSubcategoryByIdParam): SubcategoryModel {
        return this.mapToDomainSubById(
            subcategoryModelDb = subcategoryStorage.getSubcategoryById(
                idSubcategory = mapToStorageSub(param = param)
            )
        )
    }

    private fun mapToDomainListSub(subcategoryModelDb: List<SubcategoryModelDb>): List<SubcategoryModel> {
        var listSubcategoryAndStatisticModel = ArrayList<SubcategoryModel>()
        subcategoryModelDb.forEach { it ->
            listSubcategoryAndStatisticModel.add(
                SubcategoryModel(
                    id = it.id,
                    name = it.nameRu,
                    categoryId = it.categoryId,
                    quantityOfQuestionsId = it.quantityOfQuestionsId,
                    statisticEasy = it.statisticEasy,
                    statisticNorm = it.statisticNorm,
                    statisticHard = it.statisticHard,
                    linkToBackground = it.linkToBackground,
                    linkToIcon = it.linkToIcon
                )
            )
        }
        return listSubcategoryAndStatisticModel
    }

    private fun mapToDomainSubById(subcategoryModelDb: SubcategoryModelDb):
            SubcategoryModel {
        return SubcategoryModel(
            id = subcategoryModelDb.id,
            name = subcategoryModelDb.nameRu,
            categoryId = subcategoryModelDb.categoryId,
            quantityOfQuestionsId = subcategoryModelDb.quantityOfQuestionsId,
            statisticEasy = subcategoryModelDb.statisticEasy,
            statisticNorm = subcategoryModelDb.statisticNorm,
            statisticHard = subcategoryModelDb.statisticHard,
            linkToBackground = subcategoryModelDb.linkToBackground,
            linkToIcon = subcategoryModelDb.linkToIcon
        )
    }

    private fun mapToStorageListSub(param: GetListSubcategory): Long {
        return param.idCategory
    }

    private fun mapToStorageSub(param: GetSubcategoryByIdParam): Long {
        return param.idSubcategory
    }
}