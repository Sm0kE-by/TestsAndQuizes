package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.QuantityOfHintModelSP


interface QuantityOfHintStorage {

    fun get(): QuantityOfHintModelSP

    fun save(hint: QuantityOfHintModelSP): Boolean
}