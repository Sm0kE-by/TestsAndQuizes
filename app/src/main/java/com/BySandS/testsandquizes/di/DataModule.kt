package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.data.test.repository.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.test.storage.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoQuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoSubcategoryStorage
import com.BySandS.testsandquizes.domain.tests.repository.QuantityOfQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository
import org.koin.dsl.module

/**
 * Обычно Repository and Storage делают single<>
 */

val dataModule = module {

    // single<SubcategoryStorage> = SubcategoryStorage - интерфейс
    single<SubcategoryStorage> {
        //DaoSubcategoryStorage - имплементация
        DaoSubcategoryStorage(context = get())
    }
    single<TestSubcategoryRepository> {
        TestSubcategoryRepositoryImpl(subcategoryStorage = get())
    }

    single<QuantityOfQuestionStorage> {
        DaoQuantityOfQuestionStorage(context = get())
    }
    single<QuantityOfQuestionRepository> {
        TestQuantityOfQuestionRepositoryImpl(quantityOfQuestionStorage = get())
    }
}