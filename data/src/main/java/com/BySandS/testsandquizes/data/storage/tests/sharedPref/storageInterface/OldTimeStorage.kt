package com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.sharedPref.models.OldTimeModelSP

interface OldTimeStorage {

    fun get():OldTimeModelSP

    fun save(time: OldTimeModelSP):Boolean

}