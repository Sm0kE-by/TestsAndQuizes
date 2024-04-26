package com.BySandS.testsandquizes.domain.tests.usecase.mainActivity

import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategoryParam
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModelForSubcategoryFragment
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository


class GetListSubcategoryUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {

    fun execute(param: GetListSubcategoryParam): List<SubcategoryModelForSubcategoryFragment> {
        return testSubcategoryRepository.getListSubcategories(param = param)
    }
}