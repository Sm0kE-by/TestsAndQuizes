package com.BySandS.testsandquizes.data.tests.storage.dataBase.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.tests.storage.dataBase.models.QuestionModelDb

@Dao
interface DaoQuestionRu {
    @Query("SELECT * FROM  question " +
            "WHERE question.difficulty_id = :difficultyId " +
            "ORDER BY RANDOM() LIMIT :quantityOfQuestions")
    fun getQuestionsListByDifficulty(difficultyId: Long, quantityOfQuestions: Int): List<QuestionModelDb>
}