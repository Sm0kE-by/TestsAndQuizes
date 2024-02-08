package com.BySandS.testsandquizes.DataBase

import android.app.Application
import androidx.room.Room

/**
 * Инициализируем репозиторий
 * и добавляем его в автозагрузку в манифесте
 */
class TestsApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        TestsRepository.initialize(this)

    }
}