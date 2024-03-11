package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.data.test.repository.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestResultRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.test.storage.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.QuestionStorage
import com.BySandS.testsandquizes.data.test.storage.ResultStorage
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoQuantityOfQuestionStorageImpl
import com.BySandS.testsandquizes.data.test.storage.dao.DaoQuestionStorageImpl
import com.BySandS.testsandquizes.data.test.storage.dao.DaoResultStorageImpl
import com.BySandS.testsandquizes.data.test.storage.dao.DaoSubcategoryStorageImpl
import com.BySandS.testsandquizes.domain.tests.repository.TestQuantityOfQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository
import org.koin.dsl.module

/**
 * Обычно Repository and Storage делают single<>
 */

val dataModule = module {

// single<SubcategoryStorage> = SubcategoryStorage - интерфейс
    single<SubcategoryStorage> {
//DaoSubcategoryStorage - имплементация
        DaoSubcategoryStorageImpl(context = get())
    }
    single<QuantityOfQuestionStorage> {
        DaoQuantityOfQuestionStorageImpl(context = get())
    }
    single<ResultStorage> {
        DaoResultStorageImpl(context = get())
    }
    single<QuestionStorage> {
        DaoQuestionStorageImpl(context = get())
    }


    single<TestSubcategoryRepository> {
        TestSubcategoryRepositoryImpl(subcategoryStorage = get())
    }
    single<TestQuantityOfQuestionRepository> {
        TestQuantityOfQuestionRepositoryImpl(quantityOfQuestionStorage = get())
    }
    single<TestResultRepository> {
        TestResultRepositoryImpl(resultStorage = get())
    }
    single<TestQuestionRepository> {
        TestQuestionRepositoryImpl(questionStorage = get())
    }
}