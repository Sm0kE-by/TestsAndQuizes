package com.BySandS.testsandquizes.data.allData.repository

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.AdvertisingTodayModelSP
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.AdvertisingTodayStorage
import com.BySandS.testsandquizes.domain.allData.models.getHint.AdvertisingTodayModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveAdvertisingParam
import com.BySandS.testsandquizes.domain.allData.repository.AdvertisingTodayRepository

class AllDataAdvertisingTodayRepositoryImpl(private val advertisingTodayStorage: AdvertisingTodayStorage) :
    AdvertisingTodayRepository {
    override fun get(): AdvertisingTodayModel {
       return mapToDomain(advertisingTodayModelSP = advertisingTodayStorage.get())
    }

    override fun save(param: SaveAdvertisingParam): Boolean {
       return advertisingTodayStorage.save(mapToStorage(param = param))
    }

    private fun mapToDomain(advertisingTodayModelSP: AdvertisingTodayModelSP): AdvertisingTodayModel {
        return AdvertisingTodayModel(
            quantity = advertisingTodayModelSP.quantity,
            date = advertisingTodayModelSP.date
        )
    }

    private fun mapToStorage(param: SaveAdvertisingParam): AdvertisingTodayModelSP {
        return AdvertisingTodayModelSP(quantity = param.quantity, date = param.date)
    }

}