package com.BySandS.testsandquizes.domain.tests.usecase.testActivity

import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

class GetTestSubcategoryByIdUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {
    fun execute(param: GetSubcategoryByIdParam): SubcategoryModel {
        return testSubcategoryRepository.getSubcategoryById(param = param)
    }
}