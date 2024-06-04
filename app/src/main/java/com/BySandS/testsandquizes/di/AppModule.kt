package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.presentation.mainActivity.DifficultyFragmentViewModel
import com.BySandS.testsandquizes.presentation.mainActivity.MainMenuViewModel
import com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments.GetHintDialogFragmentViewModel
import com.BySandS.testsandquizes.presentation.mainActivity.SubcategoriesViewModel
import com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments.AvatarDialogFragmentViewModel
import com.BySandS.testsandquizes.presentation.testsActivity.TestFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<SubcategoriesViewModel> {
        SubcategoriesViewModel(getListSubcategoryUseCase = get())
    }


    viewModel<DifficultyFragmentViewModel> {
        DifficultyFragmentViewModel(
            getQuantityOfQuestionUseCase = get(),
            getTestSubcategoryUseCase = get()
        )
    }
    viewModel<TestFragmentViewModel> {
        TestFragmentViewModel(
            getTestResultUseCase = get(),
            getQuestionListUseCase = get(),
            getTestSubcategoryByIdUseCase = get(),
            updateTestSubcategoryUseCase = get(),
            getQuantityOfHintUseCase = get(),
            saveQuantityOfHintUseCase = get(),
        )
    }
    viewModel<GetHintDialogFragmentViewModel> {
        GetHintDialogFragmentViewModel(
            getAdvertisingTodayUseCase = get(),
            getOldTimeUseCase = get(),
            getQuantityOfHintUseCase = get(),
            saveAdvertisingTodayUseCase = get(),
            saveOldTimeUseCase = get(),
            saveQuantityOfHintUseCase = get(),
        )
    }
    viewModel<AvatarDialogFragmentViewModel> {
        AvatarDialogFragmentViewModel(
            getAvatarByIdUseCase = get(),
            getListAvatarsUseCase = get(),
            saveAvatarSPUseCase = get(),
        )
    }
    viewModel<MainMenuViewModel> {
        MainMenuViewModel(
            getQuantityOfHintUseCase = get(),
        )
    }
}