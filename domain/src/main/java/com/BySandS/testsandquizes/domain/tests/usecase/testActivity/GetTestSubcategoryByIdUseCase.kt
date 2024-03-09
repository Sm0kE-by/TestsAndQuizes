package com.BySandS.testsandquizes.domain.tests.usecase.testActivity

import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryParam
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

class GetTestSubcategoryByIdUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {
    fun execute(param: GetSubcategoryParam): SubcategoryModel {
        return testSubcategoryRepository.getSubcategoryById(param = param)
    }
}