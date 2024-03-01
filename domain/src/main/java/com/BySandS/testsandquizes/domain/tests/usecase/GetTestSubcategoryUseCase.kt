package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.param.GetCategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository


class GetTestSubcategoryUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {

    fun execute(param: GetCategoryParam): List<SubcategoryModel> {
        return testSubcategoryRepository.getAllSubcategories(param = param)
    }
}