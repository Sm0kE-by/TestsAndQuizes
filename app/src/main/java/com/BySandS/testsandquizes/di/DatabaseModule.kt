package com.BySandS.testsandquizes.di

import com.BySandS.testsandquizes.data.tests.storage.dataBase.AppDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        AppDatabase.getInstance(get())
    }

}