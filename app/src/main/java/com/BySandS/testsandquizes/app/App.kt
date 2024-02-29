package com.BySandS.testsandquizes.app

import android.app.Application
import com.BySandS.testsandquizes.data.AppDatabase
import com.BySandS.testsandquizes.di.appModule
import com.BySandS.testsandquizes.di.dataModule
import com.BySandS.testsandquizes.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Инициализируем репозиторий
 * и добавляем его в автозагрузку в манифесте
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            //вывод ошибок
            androidLogger(Level.ERROR)
            //добавляем Контекс
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
        AppDatabase.getInstance(this)
    }
}