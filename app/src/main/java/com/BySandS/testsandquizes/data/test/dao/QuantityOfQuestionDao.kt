package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.models.QuantityOfQuestionModelDb
import com.BySandS.testsandquizes.data.test.models.QuestionModelDb
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel

@Dao
interface QuantityOfQuestionDao {

//    @Query("")
//    fun getQuantityOfQuestion(idSubcategory: GetQuantityOfQuestionParam): QuantityOfQuestionModelDb
}