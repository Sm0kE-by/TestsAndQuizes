package com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.OldTimeModelSP
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.OldTimeStorage

const val SHARED_PREFS_OLD_TIME_NAME = "SHARED_PREFS_NAME"
const val KEY_OLD_TIME_QUANTITY = "KEY_QUANTITY"
class OldTimeStorageImpl(context: Context): OldTimeStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_OLD_TIME_NAME, Context.MODE_PRIVATE)
    override fun get(): OldTimeModelSP {
        // 11 - default
        return OldTimeModelSP(time = sharedPreferences.getLong(KEY_OLD_TIME_QUANTITY, 11))
    }

    override fun save(time: OldTimeModelSP): Boolean {
        sharedPreferences.edit().putLong(KEY_OLD_TIME_QUANTITY, time.time).apply()
        return true
    }
}