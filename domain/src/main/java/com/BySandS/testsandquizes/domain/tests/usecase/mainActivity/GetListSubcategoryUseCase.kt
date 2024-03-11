package com.BySandS.testsandquizes.domain.tests.usecase.mainActivity

import com.BySandS.testsandquizes.domain.tests.models.param.GetListSubcategory
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository


class GetListSubcategoryUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {

    fun execute(param: GetListSubcategory): List<SubcategoryModel> {
        return testSubcategoryRepository.getListSubcategories(param = param)
    }
}