package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.domain.allData.useCase.GetAdvertisingTodayUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.GetOldTimeUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.GetQuantityOfHintUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.SaveAdvertisingTodayUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.SaveOldTimeUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.SaveQuantityOfHintUseCase
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

}