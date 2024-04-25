package com.BySandS.testsandquizes.data.tests.repositry

import com.BySandS.testsandquizes.data.storage.tests.dataBase.storageInterface.ResultStorage
import com.BySandS.testsandquizes.data.storage.tests.dataBase.models.ResultModelDb
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.repository.tests.TestResultRepository

class TestResultRepositoryImpl(private val resultStorage: ResultStorage) : TestResultRepository {

    override fun getResult(param: GetResultParam): ResultTestModel {
        return mapToDomain(
            resultModelDb = resultStorage.getResult(
                subcategoryId = mapToStorageResultId(param = param),
                difficultyId = mapToStorageDifficultyId(param = param)
            )
        )
    }

    private fun mapToDomain(resultModelDb: ResultModelDb): ResultTestModel {
        return ResultTestModel(
            id = resultModelDb.id,
            resultText33Ru = resultModelDb.resultText33,
            resultText66Ru = resultModelDb.resultText66,
            resultText99Ru = resultModelDb.resultText99,
            resultText100Ru = resultModelDb.resultText100
        )
    }

    private fun mapToStorageResultId(param: GetResultParam): Long {
        return param.subcategoryId
    }

    private fun mapToStorageDifficultyId(param: GetResultParam): Long {
        return param.difficultyId
    }
}