package com.BySandS.testsandquizes.data

import android.app.Application
import com.BySandS.testsandquizes.data.test.repository.TestSubcategoryRepositoryImpl

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