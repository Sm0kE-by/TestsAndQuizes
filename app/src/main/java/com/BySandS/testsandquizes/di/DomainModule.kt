package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.domain.tests.usecase.GetTestSubcategoryUseCase
import org.koin.dsl.module

/**
 * Обычно UseCase делают factory<>
 */
val domainModule = module {

    factory<GetTestSubcategoryUseCase> {
        GetTestSubcategoryUseCase(
            testSubcategoryRepository = get()
        )
    }
}