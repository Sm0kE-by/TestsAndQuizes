package com.BySandS.testsandquizes.domain.allData.useCase.getHint

import com.BySandS.testsandquizes.domain.allData.models.getHint.OldTimeModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveOldTimeParam
import com.BySandS.testsandquizes.domain.allData.repository.OldTimeRepository
import java.util.Calendar

class GetOldTimeUseCase(private val oldTimeRepository: OldTimeRepository) {

    fun execute(): OldTimeModel {
        var oldTime = oldTimeRepository.get()

        if (oldTime.oldTime !=11L) return oldTime
        else if (oldTime.oldTime == 11L) {
            if (oldTimeRepository.save(param = SaveOldTimeParam(time = Calendar.getInstance().timeInMillis)))
                oldTime = oldTimeRepository.get()
            return oldTime

        } else {
            throw Exception("Invalid value ${oldTime.oldTime}")
        }
    }
}