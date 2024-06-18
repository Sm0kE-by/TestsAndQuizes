package com.BySandS.testsandquizes.domain.allData.repository

import com.BySandS.testsandquizes.domain.allData.models.getHint.OldTimeModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveOldTimeParam

interface OldTimeRepository {

    fun get(): OldTimeModel
    fun save(param: SaveOldTimeParam): Boolean

}