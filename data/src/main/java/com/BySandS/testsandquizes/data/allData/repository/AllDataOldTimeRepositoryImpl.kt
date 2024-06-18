package com.BySandS.testsandquizes.data.allData.repository

import com.BySandS.testsandquizes.data.allData.storage.sharedPref.models.OldTimeModelSP
import com.BySandS.testsandquizes.data.allData.storage.storageInterface.OldTimeStorage
import com.BySandS.testsandquizes.domain.allData.models.getHint.OldTimeModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveOldTimeParam
import com.BySandS.testsandquizes.domain.allData.repository.OldTimeRepository

class AllDataOldTimeRepositoryImpl(private val oldTimeStorage: OldTimeStorage): OldTimeRepository {
    override fun get(): OldTimeModel {
        return mapToDomain(oldTimeModelSP = oldTimeStorage.get())
    }

    override fun save(param: SaveOldTimeParam): Boolean {
        return oldTimeStorage.save(mapToStorage(param = param))
    }

    private fun mapToDomain(oldTimeModelSP: OldTimeModelSP): OldTimeModel {
        return OldTimeModel(oldTime = oldTimeModelSP.time)
    }

    private fun mapToStorage(param: SaveOldTimeParam): OldTimeModelSP{
        return OldTimeModelSP(time = param.time)
    }
}