package com.BySandS.testsandquizes.data.allData.storage.sharedPref.storageInterfaceImpl

import android.content.Context
import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.QuantityOfHintModelSP
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.QuantityOfHintStorage

const val SHARED_PREFS_HINT_NAME = "SHARED_PREFS_HINT_NAME"
const val KEY_HINT_QUANTITY = "KEY_HINT_QUANTITY"


class QuantityOfHintStorageImpl(context: Context): QuantityOfHintStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_HINT_NAME, Context.MODE_PRIVATE)
    override fun get(): QuantityOfHintModelSP {
        // 11 - default
       return QuantityOfHintModelSP(quantity = sharedPreferences.getInt(KEY_HINT_QUANTITY, 11))
    }

    override fun save(hint: QuantityOfHintModelSP): Boolean {
        sharedPreferences.edit().putInt(KEY_HINT_QUANTITY, hint.quantity).apply()
        return true
    }
}