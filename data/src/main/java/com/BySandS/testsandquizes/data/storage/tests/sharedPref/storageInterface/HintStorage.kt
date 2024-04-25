package com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.sharedPref.models.HintModelSP


interface HintStorage {

    fun get(): HintModelSP

    fun save(hint: HintModelSP): Boolean
}