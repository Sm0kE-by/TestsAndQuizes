package com.BySandS.testsandquizes.data.test.repository

import com.BySandS.testsandquizes.data.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelDb
import com.BySandS.testsandquizes.data.test.storage.models.SubcategoryModelForSubcategoryFragmentDb
import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModelForSubcategoryFragment
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

/**
 * Вместо маперов лучше сделать Extantion
 */
class TestSubcategoryRepositoryImpl(private val subcategoryStorage: SubcategoryStorage) :
    TestSubcategoryRepository {

    override fun getListSubcategories(param: GetListSubcategoryParam): List<SubcategoryModelForSubcategoryFragment> {
        return mapToDomainListSub(
            subcategoryModelDb = subcategoryStorage.getListSubcategories(
                idCategory = mapToStorageListSub(param = param)
            )
        )
    }

    override fun getSubcategoryById(param: GetSubcategoryByIdParam): SubcategoryModel {
        return mapToDomainSubById(
            subcategoryModelDb = subcategoryStorage.getSubcategoryById(
                idSubcategory = mapToStorageSub(param = param)
            )
        )
    }

    override fun updateSubcategory(subcategory: SubcategoryModel) {
        return subcategoryStorage.updateSubcategory(mapToStorageSubUpdate(subcategory))
    }

    private fun mapToDomainListSub(subcategoryModelDb: List<SubcategoryModelForSubcategoryFragmentDb>): List<SubcategoryModelForSubcategoryFragment> {
        var listSubcategoryAndStatisticModel = ArrayList<SubcategoryModelForSubcategoryFragment>()
        subcategoryModelDb.forEach { it ->
            listSubcategoryAndStatisticModel.add(
                SubcategoryModelForSubcategoryFragment(
                    id = it.id,
                    name = it.name,
                    statisticEasy = it.statisticEasy,
                    statisticNorm = it.statisticNorm,
                    statisticHard = it.statisticHard,
                    statisticVeryHard = it.statisticVeryHard,
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
            nameRu = subcategoryModelDb.nameRu,
            nameEng = subcategoryModelDb.nameEng,
            categoryId = subcategoryModelDb.categoryId,
            quantityOfQuestions = subcategoryModelDb.quantityOfQuestions,
            statisticEasy = subcategoryModelDb.statisticEasy,
            statisticNorm = subcategoryModelDb.statisticNorm,
            statisticHard = subcategoryModelDb.statisticHard,
            statisticVeryHard = subcategoryModelDb.statisticVeryHard,
            linkToBackground = subcategoryModelDb.linkToBackground,
            linkToIcon = subcategoryModelDb.linkToIcon
        )
    }
    private fun mapToStorageSubUpdate(subcategory: SubcategoryModel):
            SubcategoryDbEntity {
        return SubcategoryDbEntity(
            id = subcategory.id,
            nameRu = subcategory.nameRu,
            nameEng = subcategory.nameEng,
            categoryId = subcategory.categoryId,
            quantityOfQuestions = subcategory.quantityOfQuestions,
            statisticEasy = subcategory.statisticEasy,
            statisticNorm = subcategory.statisticNorm,
            statisticHard = subcategory.statisticHard,
            statisticVeryHard = subcategory.statisticVeryHard,
            linkToBackground = subcategory.linkToBackground,
            linkToIcon = subcategory.linkToIcon
        )
    }

    private fun mapToStorageListSub(param: GetListSubcategoryParam): Long {
        return param.idCategory
    }

    private fun mapToStorageSub(param: GetSubcategoryByIdParam): Long {
        return param.idSubcategory
    }
}