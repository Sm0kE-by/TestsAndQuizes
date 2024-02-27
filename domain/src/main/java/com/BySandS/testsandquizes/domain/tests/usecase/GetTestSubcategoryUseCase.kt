package com.BySandS.testsandquizes.domain.tests.usecase


class GetTestSubcategoryUseCase(private val testSubcategoryRepository: com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository) {

    fun execute(param: com.BySandS.testsandquizes.domain.tests.models.GetCategoryParam): List<com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel> {
        return testSubcategoryRepository.getAllSubcategories(idCategory = param)
    }
}