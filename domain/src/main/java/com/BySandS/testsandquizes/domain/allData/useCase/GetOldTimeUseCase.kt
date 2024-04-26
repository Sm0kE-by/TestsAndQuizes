package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.OldTimeModel
import com.BySandS.testsandquizes.domain.allData.models.param.SaveOldTimeParam
import com.BySandS.testsandquizes.domain.allData.repository.OldTimeRepository
import java.util.Calendar

class GetOldTimeUseCase(private val oldTimeRepository: OldTimeRepository) {

    fun execute(): OldTimeModel{
        var oldTime = oldTimeRepository.get()

        if (oldTime.oldTime !=11L) return oldTime
        else if (oldTime.oldTime == 11L) {
            if (oldTimeRepository.save(param = SaveOldTimeParam(Calendar.getInstance().timeInMillis)))
                oldTime = oldTimeRepository.get()
            else{

            }
        } else {
            throw Exception("Invalid value ${oldTime.oldTime}")
        }
        return oldTime
    }

}