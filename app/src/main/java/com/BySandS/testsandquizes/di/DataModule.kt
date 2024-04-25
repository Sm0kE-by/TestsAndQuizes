package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.data.tests.repositry.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.tests.repositry.TestQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.tests.repositry.TestResultRepositoryImpl
import com.BySandS.testsandquizes.data.tests.repositry.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.QuestionStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.ResultStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.SubcategoryStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.DaoQuantityOfQuestionStorageImpl
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.DaoQuestionStorageImpl
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.DaoResultStorageImpl
import com.BySandS.testsandquizes.data.storage.tests.dataBase.dao.DaoSubcategoryStorageImpl
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestQuantityOfQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestResultRepository
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestSubcategoryRepository
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