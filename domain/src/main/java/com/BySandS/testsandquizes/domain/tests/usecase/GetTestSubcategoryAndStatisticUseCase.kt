package com.BySandS.testsandquizes.domain.tests.usecase

import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository


class GetTestSubcategoryAndStatisticUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {

    fun execute(param: GetSubcategoryAndStatisticParam): List<SubcategoryAndStatisticModel> {
        return testSubcategoryRepository.getAllSubcategoriesAndStatistic(param = param)
    }
}