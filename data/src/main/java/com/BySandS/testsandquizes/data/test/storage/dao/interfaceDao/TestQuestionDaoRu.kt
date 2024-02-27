package com.BySandS.testsandquizes.data.test.storage.dao.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.BySandS.testsandquizes.data.test.storage.models.QuestionModelDb

@Dao
interface TestQuestionDaoRu {
    @Query("SELECT question_text.id, question_text.question_text_ru, question_text.correct_answer_ru," +
            "question_text.incorrect_answer_1_ru, question_text.incorrect_answer_2_ru," +
            "question_text.incorrect_answer_3_ru " +
            "FROM question_text, question " +
           // "JOIN question_text ON question.question_text_id = question_text.id " +
            "WHERE question.difficulty_id = :difficultyId AND question_text.id = question.question_text_id " +
            "ORDER BY RANDOM() LIMIT :quantityOfQuestions")
    fun getQuestionsListByDifficulty(difficultyId: Long, quantityOfQuestions: Int): List<QuestionModelDb>
}