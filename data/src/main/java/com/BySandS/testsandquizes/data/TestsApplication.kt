package com.BySandS.testsandquizes.data

import android.app.Application

/**
 * Инициализируем репозиторий
 * и добавляем его в автозагрузку в манифесте
 */
class TestsApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.getInstance(this)

    }
}