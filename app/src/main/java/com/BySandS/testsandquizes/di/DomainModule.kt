package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetAdvertisingTodayUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.GetAvatarByIdUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.GetAvatarForMainMenuUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.GetListAvatarsUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetOldTimeUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetQuantityOfHintUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.SaveAdvertisingTodayUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.SaveOpenAvatarDbUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.avatar.SaveAvatarSPUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.SaveOldTimeUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.SaveQuantityOfHintUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetQuantityOfQuestionUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetListSubcategoryUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetTestSubcategoryUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.UpdateTestSubcategoryUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestSubcategoryByIdUseCase
import org.koin.dsl.module

/**
 * Обычно UseCase делают factory<>
 */

val domainModule = module {

    //TESTS
    factory<GetListSubcategoryUseCase> {
        GetListSubcategoryUseCase(
            testSubcategoryRepository = get()
        )
    }
    factory<GetTestSubcategoryUseCase> {
        GetTestSubcategoryUseCase(
            testSubcategoryRepository = get()
        )
    }
    factory<UpdateTestSubcategoryUseCase> {
        UpdateTestSubcategoryUseCase(
            testSubcategoryRepository = get()
        )
    }
    factory<GetTestSubcategoryByIdUseCase> {
        GetTestSubcategoryByIdUseCase(
            testSubcategoryRepository = get()
        )
    }
    factory<GetQuantityOfQuestionUseCase> {
        GetQuantityOfQuestionUseCase(
            testQuantityOfQuestionRepository = get()
        )
    }
    factory<GetQuestionListUseCase> {
        GetQuestionListUseCase(
            tesQuestionRepository = get()
        )
    }
    factory<GetTestResultUseCase> {
        GetTestResultUseCase(
            testResultRepository = get()
        )
    }

    //ALLDATA
    factory<GetAdvertisingTodayUseCase> {
        GetAdvertisingTodayUseCase(
            advertisingTodayRepository = get()
        )
    }
    factory<GetOldTimeUseCase> {
        GetOldTimeUseCase(
            oldTimeRepository = get()
        )
    }
    factory<GetQuantityOfHintUseCase> {
        GetQuantityOfHintUseCase(
            quantityOfHintRepository = get()
        )
    }
    factory<GetAvatarForMainMenuUseCase> {
        GetAvatarForMainMenuUseCase(
            avatarRepository = get()
        )
    }
    factory<GetListAvatarsUseCase> {
        GetListAvatarsUseCase(
            avatarRepository = get()
        )
    }
    factory<GetAvatarByIdUseCase> {
        GetAvatarByIdUseCase(
            avatarRepository = get()
        )
    }

    factory<SaveAdvertisingTodayUseCase> {
        SaveAdvertisingTodayUseCase(
            advertisingTodayRepository = get()
        )
    }
    factory<SaveOldTimeUseCase> {
        SaveOldTimeUseCase(
            oldTimeRepository = get()
        )
    }
    factory<SaveQuantityOfHintUseCase> {
        SaveQuantityOfHintUseCase(
            quantityOfHintRepository = get()
        )
    }
    factory<SaveOpenAvatarDbUseCase> {
        SaveOpenAvatarDbUseCase(
            avatarRepository = get()
        )
    }
    factory<SaveAvatarSPUseCase> {
        SaveAvatarSPUseCase(
            avatarRepository = get()
        )
    }

}