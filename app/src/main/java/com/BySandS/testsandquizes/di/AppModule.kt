package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.presentation.mainActivity.SubcategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<SubcategoriesViewModel> {
        SubcategoriesViewModel(
            getTestSubcategoryUseCase = get()
        )
    }
}