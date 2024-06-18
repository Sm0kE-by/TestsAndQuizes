package com.BySandS.testsandquizes.domain.allData.useCase.getHint

import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveQuantityOfHintParam
import com.BySandS.testsandquizes.domain.allData.repository.QuantityOfHintRepository

class GetQuantityOfHintUseCase(private val quantityOfHintRepository: QuantityOfHintRepository) {

    fun execute(): QuantityOfHintModel {
        var quantity = quantityOfHintRepository.get()

        if (quantity.quantity in 0..2) return quantity
        else if (quantity.quantity == 11) {
            if (quantityOfHintRepository.save(param = SaveQuantityOfHintParam(0)))
                quantity = quantityOfHintRepository.get()
            else{

            }
        } else {
            throw Exception("Invalid value ${quantity.quantity}")
        }
        return quantity
    }

}