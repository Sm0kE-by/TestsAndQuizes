package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryUseCase


class SubcategoriesFragmentViewModel : ViewModel() {

    private val testSubcategoryRepository = TestSubcategoryRepository()
//    val listSubcategoryModelLiveData = testSubcategoryRepositoryImpl.getAllSubcategories()

    private val getTestSubcategoryUseCase = GetTestSubcategoryUseCase(testSubcategoryRepository)

}