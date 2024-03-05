package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.presentation.mainActivity.DifficultyFragmentViewModel
import com.BySandS.testsandquizes.presentation.mainActivity.SubcategoriesViewModel
import com.BySandS.testsandquizes.presentation.testsActivity.TestFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<SubcategoriesViewModel> {
        SubcategoriesViewModel(getTestSubcategoryAndStatisticUseCase = get())
    }

    viewModel<DifficultyFragmentViewModel> {
        DifficultyFragmentViewModel(getQuantityOfQuestionUseCase = get())
    }
    viewModel<TestFragmentViewModel> {
        TestFragmentViewModel(
            getTestResultUseCase = get(),
            getQuestionListUseCase = get(),
            saveTestStatisticUseCase = get(),
            getTestStatisticUseCase = get()
            )
    }
}