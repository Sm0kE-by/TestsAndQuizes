package com.BySandS.testsandquizes.domain.allData.repository

import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveQuantityOfHintParam

interface QuantityOfHintRepository {

    fun get(): QuantityOfHintModel
    fun save(param: SaveQuantityOfHintParam): Boolean

}