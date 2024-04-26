package com.BySandS.testsandquizes.domain.allData.useCase

import com.BySandS.testsandquizes.domain.allData.models.param.SaveQuantityOfHintParam
import com.BySandS.testsandquizes.domain.allData.repository.QuantityOfHintRepository

class SaveQuantityOfHintUseCase(private val quantityOfHintRepository: QuantityOfHintRepository) {

    fun execute(saveQuantityOfHintParam: SaveQuantityOfHintParam): Boolean {
        return if (quantityOfHintRepository.get().quantity == saveQuantityOfHintParam.quantity) true
        else quantityOfHintRepository.save(param = saveQuantityOfHintParam)
    }

}