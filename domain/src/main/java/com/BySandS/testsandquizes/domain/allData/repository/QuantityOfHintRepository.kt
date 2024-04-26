package com.BySandS.testsandquizes.domain.allData.repository

import com.BySandS.testsandquizes.domain.allData.models.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.models.param.SaveQuantityOfHintParam

interface QuantityOfHintRepository {

    fun get(): QuantityOfHintModel
    fun save(param: SaveQuantityOfHintParam): Boolean

}