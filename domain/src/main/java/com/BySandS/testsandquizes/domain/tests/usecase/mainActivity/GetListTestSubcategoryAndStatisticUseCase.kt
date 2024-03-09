package com.BySandS.testsandquizes.domain.tests.usecase.mainActivity

import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategoryAndStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryAndStatisticModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository


class GetListTestSubcategoryAndStatisticUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {

    fun execute(param: GetListSubcategoryAndStatisticParam): List<SubcategoryAndStatisticModel> {
        return testSubcategoryRepository.getAllSubcategoriesAndStatistic(param = param)
    }
}