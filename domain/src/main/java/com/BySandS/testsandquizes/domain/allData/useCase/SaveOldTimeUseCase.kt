package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.param.SaveOldTimeParam
import com.BySandS.testsandquizes.domain.allData.repository.OldTimeRepository

class SaveOldTimeUseCase(private val oldTimeRepository: OldTimeRepository) {

    fun execute(saveOldTimeParam: SaveOldTimeParam): Boolean {
        return if (oldTimeRepository.get().oldTime == saveOldTimeParam.time) true
        else oldTimeRepository.save(param = saveOldTimeParam)
    }

}