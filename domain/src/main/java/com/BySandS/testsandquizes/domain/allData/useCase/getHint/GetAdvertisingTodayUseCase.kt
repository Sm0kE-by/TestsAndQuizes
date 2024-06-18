package com.BySandS.testsandquizes.domain.allData.useCase.getHint

import com.BySandS.testsandquizes.domain.allData.models.getHint.AdvertisingTodayModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveAdvertisingParam
import com.BySandS.testsandquizes.domain.allData.repository.AdvertisingTodayRepository
import java.util.Calendar

class GetAdvertisingTodayUseCase(private val advertisingTodayRepository: AdvertisingTodayRepository) {

    /**
     * Надо перепроверить метод
     * загружаю "показов рекламы" из хранилища
     * загружаю текущее время и сохраненное
     * сравниваю сохраненное время в ДНЯХ с текущим временем в ДНЯХ
     * если они равны - проверяю количество показов сегодня и если их меньше 2 - то возвращаю объект
     * иначе (дни не равны) создаю новый объект с показами = 0 и текущим временем, сохраняю его в память устройства и возвращаю из метода
     */
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
            advertisingToday = AdvertisingTodayModel(quantity = 0, date = currentTime.timeInMillis)
            advertisingTodayRepository.save(
                param = SaveAdvertisingParam(
                    quantity = advertisingToday.quantity,
                    date = advertisingToday.date
                )
            )
            return advertisingToday
        }
        return advertisingToday
    }
}