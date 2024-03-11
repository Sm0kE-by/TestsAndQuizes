package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetQuantityOfQuestionUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetListSubcategoryUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetTestSubcategoryUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestSubcategoryByIdUseCase
import org.koin.dsl.module

/**
 * Обычно UseCase делают factory<>
 */

val domainModule = module {

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
}