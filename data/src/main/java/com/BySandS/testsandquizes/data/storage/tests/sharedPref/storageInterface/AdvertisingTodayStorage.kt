package com.BySandS.testsandquizes.data.storage.tests.sharedPref.storageInterface

import com.BySandS.testsandquizes.data.storage.tests.sharedPref.models.AdvertisingTodayModelSP

interface AdvertisingTodayStorage {

    fun get(): AdvertisingTodayModelSP

    fun save(advertising: AdvertisingTodayModelSP):Boolean
}