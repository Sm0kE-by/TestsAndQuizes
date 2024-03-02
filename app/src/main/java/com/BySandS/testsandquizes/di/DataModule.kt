package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.data.test.repository.TestTestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestResultRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestStatisticRepositoryImpl
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.test.storage.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.QuestionStorage
import com.BySandS.testsandquizes.data.test.storage.ResultStorage
import com.BySandS.testsandquizes.data.test.storage.StatisticStorage
import com.BySandS.testsandquizes.data.test.storage.SubcategoryStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoQuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoQuestionStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoResultStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoStatisticStorage
import com.BySandS.testsandquizes.data.test.storage.dao.DaoSubcategoryStorage
import com.BySandS.testsandquizes.domain.tests.repository.TestQuantityOfQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestStatisticRepository
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
    single<QuantityOfQuestionStorage> {
        DaoQuantityOfQuestionStorage(context = get())
    }
    single<ResultStorage> {
        DaoResultStorage(context = get())
    }
    single<StatisticStorage> {
        DaoStatisticStorage(context = get())
    }
    single<QuestionStorage> {
        DaoQuestionStorage(context = get())
    }


    single<TestSubcategoryRepository> {
        TestSubcategoryRepositoryImpl(subcategoryStorage = get())
    }
    single<TestQuantityOfQuestionRepository> {
        TestTestQuantityOfQuestionRepositoryImpl(quantityOfQuestionStorage = get())
    }
    single<TestResultRepository> {
        TestResultRepositoryImpl(resultStorage = get())
    }
    single<TestStatisticRepository> {
        TestStatisticRepositoryImpl(statisticStorage = get())
    }
    single<TestQuestionRepository> {
        TestQuestionRepositoryImpl(questionStorage = get())
    }
}