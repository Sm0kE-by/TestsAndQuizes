package com.BySandS.testsandquizes.domain.allData.useCase.getHint

import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveAdvertisingParam
import com.BySandS.testsandquizes.domain.allData.repository.AdvertisingTodayRepository

class SaveAdvertisingTodayUseCase (private val advertisingTodayRepository: AdvertisingTodayRepository){

    fun execute(saveAdvertisingParam: SaveAdvertisingParam): Boolean {
        return advertisingTodayRepository.save(param = saveAdvertisingParam)
    }

}