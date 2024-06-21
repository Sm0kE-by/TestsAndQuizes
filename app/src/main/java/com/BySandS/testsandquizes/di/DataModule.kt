package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.data.allData.repository.AllDataAdvertisingTodayRepositoryImpl
import com.BySandS.testsandquizes.data.allData.repository.AllDataOldTimeRepositoryImpl
import com.BySandS.testsandquizes.data.allData.repository.AllDataQuantityOfHintRepositoryImpl
import com.BySandS.testsandquizes.data.allData.repository.AllDateAvatarRepositoryImpl
import com.BySandS.testsandquizes.data.allData.repository.AllDateUserStatisticRepositoryImpl
import com.BySandS.testsandquizes.data.allData.storage.dataBase.storageInterfaceImpl.AvatarStorageDbImpl
import com.BySandS.testsandquizes.data.allData.storage.dataBase.storageInterfaceImpl.UserStatisticStorageImpl
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl.AdvertisingTodayStorageImpl
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl.AvatarStorageSharedPrefImpl
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl.OldTimeStorageImpl
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl.QuantityOfHintStorageImpl
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AdvertisingTodayStorage
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageDb
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AvatarStorageSharedPref
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.OldTimeStorage
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.QuantityOfHintStorage
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.UserStatisticStorage
import com.BySandS.testsandquizes.data.tests.repositry.TestQuantityOfQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.tests.repositry.TestQuestionRepositoryImpl
import com.BySandS.testsandquizes.data.tests.repositry.TestResultRepositoryImpl
import com.BySandS.testsandquizes.data.tests.repositry.TestSubcategoryRepositoryImpl
import com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl.DaoQuantityOfQuestionStorageImpl
import com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl.DaoQuestionStorageImpl
import com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl.DaoResultStorageImpl
import com.BySandS.testsandquizes.data.tests.storage.dataBase.storageInterfaceImpl.DaoSubcategoryStorageImpl
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.QuantityOfQuestionStorage
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.QuestionStorage
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.ResultStorage
import com.BySandS.testsandquizes.data.tests.storage.storageInterface.SubcategoryStorage
import com.BySandS.testsandquizes.domain.allData.repository.AdvertisingTodayRepository
import com.BySandS.testsandquizes.domain.allData.repository.AvatarRepository
import com.BySandS.testsandquizes.domain.allData.repository.OldTimeRepository
import com.BySandS.testsandquizes.domain.allData.repository.QuantityOfHintRepository
import com.BySandS.testsandquizes.domain.allData.repository.UserStatisticRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestQuantityOfQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestQuestionRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestResultRepository
import com.BySandS.testsandquizes.domain.tests.repository.TestSubcategoryRepository
import org.koin.dsl.module

/**
 * Обычно Repository and Storage делают single<>
 */

val dataModule = module {

    //TESTS
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

    //ALLDATA
    single<AdvertisingTodayStorage> {
        AdvertisingTodayStorageImpl(context = get())
    }
    single<OldTimeStorage> {
        OldTimeStorageImpl(context = get())
    }
    single<QuantityOfHintStorage> {
        QuantityOfHintStorageImpl(context = get())
    }
    single<AvatarStorageDb> {
        AvatarStorageDbImpl(context = get())
    }
    single<AvatarStorageSharedPref> {
        AvatarStorageSharedPrefImpl(context = get())
    }
    single<UserStatisticStorage> {
        UserStatisticStorageImpl(context = get())
    }

    single<AdvertisingTodayRepository> {
        AllDataAdvertisingTodayRepositoryImpl(advertisingTodayStorage = get())
    }
    single<OldTimeRepository> {
        AllDataOldTimeRepositoryImpl(oldTimeStorage = get())
    }
    single<QuantityOfHintRepository> {
        AllDataQuantityOfHintRepositoryImpl(quantityOfHintStorage = get())
    }
    single<AvatarRepository> {
        AllDateAvatarRepositoryImpl(avatarStorageDb = get(), avatarStorageSharedPref = get())
    }
    single<UserStatisticRepository> {
        AllDateUserStatisticRepositoryImpl(userStatisticStorage = get())
    }
}