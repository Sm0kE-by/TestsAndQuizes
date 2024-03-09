package com.BySandS.testsandquizes.domain.tests.usecase.mainActivity

import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository

class GetTestSubcategoryAndStatisticUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {
    fun execute(param: GetSubcategoryAndStatisticParam): SubcategoryAndStatisticModel {
        return testSubcategoryRepository.getSubcategoriesAndStatisticById(param = param)
    }
}