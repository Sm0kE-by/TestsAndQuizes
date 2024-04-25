package com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.storage.tests.sharedPref.models.AdvertisingTodayModelSP
import com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterface.AdvertisingTodayStorage

const val SHARED_PREFS_ADVERTISING_NAME = "SHARED_PREFS_ADVERTISING_NAME"
const val KEY_ADVERTISING_QUANTITY = "KEY_ADVERTISING_QUANTITY"
const val KEY_ADVERTISING_DATE = "KEY_ADVERTISING_DATE"

class AdvertisingTodayStorageImpl(context: Context) : AdvertisingTodayStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_ADVERTISING_NAME, Context.MODE_PRIVATE)

    override fun get(): AdvertisingTodayModelSP {
        // 11 - default
        return AdvertisingTodayModelSP(
            quantity = sharedPreferences.getInt(KEY_ADVERTISING_QUANTITY, 11),
            date = sharedPreferences.getLong(KEY_ADVERTISING_DATE, 11)
        )
    }

    override fun save(advertising: AdvertisingTodayModelSP): Boolean {
        sharedPreferences.edit().putInt(KEY_ADVERTISING_QUANTITY, advertising.quantity).apply()
        sharedPreferences.edit().putLong(KEY_ADVERTISING_DATE, advertising.date).apply()
        return true
    }
}