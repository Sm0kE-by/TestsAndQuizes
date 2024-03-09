package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetQuantityOfQuestionUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetListTestSubcategoryAndStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.mainActivity.GetTestSubcategoryAndStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestSubcategoryByIdUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.SaveTestStatisticUseCase
import org.koin.dsl.module

/**
 * Обычно UseCase делают factory<>
 */

val domainModule = module {

    factory<GetListTestSubcategoryAndStatisticUseCase> {
        GetListTestSubcategoryAndStatisticUseCase(
            testSubcategoryRepository = get()
        )
    }
    factory<GetTestSubcategoryAndStatisticUseCase> {
        GetTestSubcategoryAndStatisticUseCase(
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