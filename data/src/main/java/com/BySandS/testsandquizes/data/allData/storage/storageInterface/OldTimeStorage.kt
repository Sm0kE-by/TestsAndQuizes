package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.OldTimeModelSP

interface OldTimeStorage {

    fun get(): OldTimeModelSP

    fun save(time: OldTimeModelSP):Boolean

}