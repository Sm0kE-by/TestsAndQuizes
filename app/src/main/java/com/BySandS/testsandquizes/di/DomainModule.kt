package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.domain.tests.usecase.GetQuantityOfQuestionUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryAndStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.SaveTestStatisticUseCase
import org.koin.dsl.module

/**
 * Обычно UseCase делают factory<>
 */

val domainModule = module {

    factory<GetTestSubcategoryAndStatisticUseCase> {
        GetTestSubcategoryAndStatisticUseCase(
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
    factory<SaveTestStatisticUseCase> {
        SaveTestStatisticUseCase(
            testStatisticRepository = get()
        )
    }
    factory<GetTestStatisticUseCase> {
        GetTestStatisticUseCase(
            testStatisticRepository = get()
        )
    }
    factory<GetTestResultUseCase> {
        GetTestResultUseCase(
            testResultRepository = get()
        )
    }
}