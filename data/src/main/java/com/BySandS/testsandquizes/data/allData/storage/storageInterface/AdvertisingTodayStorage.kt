package com.BySandS.testsandquizes.data.allData.storage.storageInterface

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.AdvertisingTodayModelSP

interface AdvertisingTodayStorage {

    fun get(): AdvertisingTodayModelSP

    fun save(advertising: AdvertisingTodayModelSP):Boolean
}