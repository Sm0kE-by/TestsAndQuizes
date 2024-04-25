package com.BySandS.testsandquizes.domain.tests.usecase.mainActivity

import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestSubcategoryRepository

class UpdateTestSubcategoryUseCase(private val testSubcategoryRepository: TestSubcategoryRepository) {

    fun execute(subcategory: SubcategoryModel) {
        return testSubcategoryRepository.updateSubcategory(subcategory)
    }
}