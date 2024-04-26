package com.BySandS.testsandquizes.domain.allData.repository

import com.BySandS.testsandquizes.domain.allData.models.AdvertisingTodayModel
import com.BySandS.testsandquizes.domain.allData.models.param.SaveAdvertisingParam

interface AdvertisingTodayRepository {

    fun get(): AdvertisingTodayModel
    fun save(param: SaveAdvertisingParam): Boolean

}