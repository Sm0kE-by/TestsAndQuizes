package com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.storage.tests.sharedPref.models.HintModelSP
import com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterface.HintStorage

const val SHARED_PREFS_HINT_NAME = "SHARED_PREFS_HINT_NAME"
const val KEY_HINT_QUANTITY = "KEY_HINT_QUANTITY"


class HintStorageImpl(context: Context): HintStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_HINT_NAME, Context.MODE_PRIVATE)
    override fun get(): HintModelSP {
        // 11 - default
       return HintModelSP(quantity = sharedPreferences.getInt(KEY_HINT_QUANTITY, 11))
    }

    override fun save(hint: HintModelSP): Boolean {
        sharedPreferences.edit().putInt(KEY_HINT_QUANTITY, hint.quantity).apply()
        return true
    }
}