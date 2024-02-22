package com.BySandS.testsandquizes.data.test.dao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.models.QuantityOfQuestionModelDb
import com.BySandS.testsandquizes.data.test.models.QuestionModelDb
import com.BySandS.testsandquizes.domain.tests.models.GetQuantityOfQuestionParam
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel

@Dao
interface QuantityOfQuestionDao {

    @Query("SELECT * FROM quantity_of_questions, subcategory " +
            "WHERE subcategory.quantity_of_questions_id = :idSubcategory")
    fun getQuantityOfQuestion(idSubcategory: Long): QuantityOfQuestionModelDb
}