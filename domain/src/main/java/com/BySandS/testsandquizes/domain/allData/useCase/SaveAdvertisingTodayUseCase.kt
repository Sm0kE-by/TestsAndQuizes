package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.param.SaveAdvertisingParam
import com.BySandS.testsandquizes.domain.allData.repository.AdvertisingTodayRepository

class SaveAdvertisingTodayUseCase (private val advertisingTodayRepository: AdvertisingTodayRepository){

    fun execute(saveAdvertisingParam: SaveAdvertisingParam): Boolean {
        return advertisingTodayRepository.save(param = saveAdvertisingParam)
    }

}