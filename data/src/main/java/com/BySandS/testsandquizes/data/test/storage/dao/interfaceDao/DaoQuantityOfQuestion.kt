package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.storage.models.QuantityOfQuestionModelDb

@Dao
interface DaoQuantityOfQuestion {

    @Query("SELECT quantity_of_questions.id, quantity_of_questions.easy_quantity, quantity_of_questions.norm_quantity, " +
            "quantity_of_questions.hard_quantity, quantity_of_questions.veryhard_quantity " +
            "FROM quantity_of_questions, subcategory " +
            "WHERE subcategory.quantity_of_questions_id = :idQuantity"
    )
    fun getQuantityOfQuestion(idQuantity: Long): QuantityOfQuestionModelDb
}