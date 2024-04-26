package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.AdvertisingTodayModel
import com.BySandS.testsandquizes.domain.allData.models.param.SaveAdvertisingParam
import com.BySandS.testsandquizes.domain.allData.repository.AdvertisingTodayRepository
import java.util.Calendar

class GetAdvertisingTodayUseCase(private val advertisingTodayRepository: AdvertisingTodayRepository) {

    fun execute(): AdvertisingTodayModel {

        var advertisingToday = advertisingTodayRepository.get()
        val currentTime = Calendar.getInstance()
        val timeToMatch = Calendar.getInstance()
        timeToMatch.timeInMillis = (advertisingToday.date)

        if (timeToMatch.get(Calendar.DAY_OF_YEAR) == currentTime.get(Calendar.DAY_OF_YEAR)) {
            if (advertisingToday.quantity in 0..2) return advertisingToday
            else if (advertisingToday.quantity == 11) {
                if (advertisingTodayRepository.save(
                        param = SaveAdvertisingParam(
                            quantity = 0,
                            date = currentTime.timeInMillis
                        )
                    )
                )
                    advertisingToday = advertisingTodayRepository.get()
                else {

                }
            } else {
                throw Exception("Invalid value ${advertisingToday.quantity}")
            }
        } else {
            return AdvertisingTodayModel(quantity = 0, date = currentTime.timeInMillis)
        }
        return advertisingToday
    }
}