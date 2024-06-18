package com.BySandS.testsandquizes.data.allData.repository

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.QuantityOfHintModelSP
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.QuantityOfHintStorage
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveQuantityOfHintParam
import com.BySandS.testsandquizes.domain.allData.repository.QuantityOfHintRepository

class AllDataQuantityOfHintRepositoryImpl(private val quantityOfHintStorage: QuantityOfHintStorage): QuantityOfHintRepository {
    override fun get(): QuantityOfHintModel {
       return mapToDomain(quantityOfHintModelSP = quantityOfHintStorage.get())
    }

    override fun save(param: SaveQuantityOfHintParam): Boolean {
        return quantityOfHintStorage.save(mapToStorage(param = param))
    }

    private fun mapToDomain(quantityOfHintModelSP: QuantityOfHintModelSP): QuantityOfHintModel {
        return QuantityOfHintModel(quantity = quantityOfHintModelSP.quantity)
    }

    private fun mapToStorage(param: SaveQuantityOfHintParam): QuantityOfHintModelSP{
        return QuantityOfHintModelSP(quantity = param.quantity)
    }
}