package com.BySandS.testsandquizes.presentation.testsActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryByIdParam
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestSubcategoryByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class TestFragmentViewModel(
    private val getTestResultUseCase: GetTestResultUseCase,
    private val getQuestionListUseCase: GetQuestionListUseCase,
    private val getTestSubcategoryByIdUseCase: GetTestSubcategoryByIdUseCase
) : ViewModel() {

    private val idSubcategory = TestFragment.idSubcategory
    private val idDifficultyLevel = TestFragment.idDifficultyLevel
    private val quantityOfQuestionMax= TestFragment.quantityOfQuestion


    private val questionListMutable = MutableLiveData<List<QuestionModel>>()
    private var numberOfQuestionMutable = MutableLiveData<Int>(0)
    private var questionMutable = MutableLiveData<QuestionModel>()
    private val quantityOfHintMutable = MutableLiveData<Int>()
    private val resultMutable = MutableLiveData<ResultTestModel>()

    val questionList: LiveData<List<QuestionModel>> = questionListMutable
    var numberOfQuestion: LiveData<Int> = numberOfQuestionMutable
    var question: LiveData<QuestionModel> = questionMutable
    val quantityOfHint: LiveData<Int> = quantityOfHintMutable
    val result: LiveData<ResultTestModel> = resultMutable

    private var quantityCorrectAnswer = 0
    private var subcategoryModel: SubcategoryModel? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val getSubcategoryByIdParam = GetSubcategoryByIdParam(idSubcategory = idSubcategory)
            subcategoryModel =
                getTestSubcategoryByIdUseCase.execute(param = getSubcategoryByIdParam)
            Log.i(TAG, "subcategoryModel ->>> ${subcategoryModel.toString()}")
            subcategoryModel.let {
                val getQuestionListParam =
                    GetQuestionListParam(
                        difficultyId = idDifficultyLevel,
                        quantityOfQuestions = quantityOfQuestionMax
                    )
                Log.i(TAG, "quantityOfQuestions ->>> ${subcategoryModel!!.quantityOfQuestions}")
                val getResultParam =
                    GetResultParam(
                        subcategoryId = subcategoryModel!!.id,
                        difficultyId = idDifficultyLevel
                    )

                //  questionListMutable.postValue(listQuestions)
                questionListMutable.postValue(getQuestionListUseCase.execute(getQuestionListParam))
                Log.i(TAG, "questionListMutable ->>> ${questionListMutable.value.toString()}")

                //  result.postValue(getTestResultUseCase.execute(param = getResultParam))
                quantityOfHintMutable.postValue(2)
                while (questionList.value == null) {
                    Thread.sleep(10L)
                    Log.i(TAG, "questionListMutable ->>> ${questionListMutable.value.toString()}")
                }
                questionMutable.postValue (
                    randomAnswerOfQuestion(questionList.value!![numberOfQuestion.value!!]))

                resultMutable.postValue(getTestResultUseCase.execute(getResultParam))
                Log.i(TAG, "resultMutable ->>> ${resultMutable.value.toString()}")
            }
        }

        //  questionMutable.value(randomAnswerOfQuestion(questionList(quantityOfQuestion.value!!)))
    }

    /**
     * Вычисление статистики пройденного теста
     */
    fun calculateResultStatistic(): Int {
        val correctAnswer: Double = quantityCorrectAnswer.toDouble()
        val listSize: Double = questionList.value!!.size.toDouble()
        return ((correctAnswer / listSize) * 100).toInt()
    }

    /**
     * Перемешивание ответов в вопросе
     */
    private fun randomAnswerOfQuestion(questionModel: QuestionModel): QuestionModel {
        Log.i(TAG, "Starting fun - randomAnswerOfQuestion")
        val list = listOf(
            questionModel.correctAnswer,
            questionModel.incorrectAnswer1,
            questionModel.incorrectAnswer2,
            questionModel.incorrectAnswer3
        ).shuffled()
        return QuestionModel(
            id = questionModel.id,
            questionText = questionModel.questionText,
            correctAnswer = list[0],
            incorrectAnswer1 = list[1],
            incorrectAnswer2 = list[2],
            incorrectAnswer3 = list[3]
        )
    }

    /**
     * Проверка правильности ответа
     */
    fun checkingAnswer(answerText: String) {
        if (answerText == questionList.value!![numberOfQuestion.value!!].correctAnswer) {
            quantityCorrectAnswer++
        } else {
        }
        updateNumberQuestion()
    }

    /**
     * Функция считает номер вопроса, увеличивает его на 1 и перемешивает ответы и записывает в вопрос
     */
    private fun updateNumberQuestion() {

        if (numberOfQuestion.value != questionList.value!!.size - 1) {
            val num: Int = numberOfQuestionMutable.value!! + 1
            numberOfQuestionMutable.value = num
            val question1 = questionList.value!![numberOfQuestionMutable.value!!]
            questionMutable.value = randomAnswerOfQuestion(question1)
        }
    }

    /**
     * Сохранение статистики
     * data Class StatisticModel - переменные типа VAR!!!!!!!!!!!!
     * if() в when()!!!!!
     */
    private fun saveStatistic() {
        val newStatistic = calculateResultStatistic()
        //val result = mapToSaveStatistic(static)
        Log.i(TAG, "New Statistic - $newStatistic")
        if (idDifficultyLevel == 1L && newStatistic > subcategoryModel!!.statisticEasy) subcategoryModel!!.statisticEasy =
            newStatistic
        if (idSubcategory == 2L && newStatistic > subcategoryModel!!.statisticNorm) subcategoryModel!!.statisticNorm =
            newStatistic
        if (idSubcategory == 3L && newStatistic > subcategoryModel!!.statisticHard) subcategoryModel!!.statisticHard =
            newStatistic
        if (idSubcategory == 4L && newStatistic > subcategoryModel!!.statisticVeryHard) subcategoryModel!!.statisticVeryHard =
            newStatistic

        // viewModelScope.launch(Dispatchers.IO) { saveTestStatisticUseCase.execute(result) }
    }

    private fun getQuestionSample(): List<QuestionModel>{
            val listQuestions: List<QuestionModel> = listOf(
        QuestionModel(
            1,
            "QuestionText 1",
            "Correct Answer 1",
            "Incorrect Answer 1 - 1",
            "Incorrect Answer 1 - 2",
            "Incorrect Answer 1 - 3"
        ),
        QuestionModel(
            2,
            "QuestionText 2",
            "Correct Answer 2",
            "Incorrect Answer 2 - 1",
            "Incorrect Answer 2 - 2",
            "Incorrect Answer 2 - 3"
        ),
        QuestionModel(
            3,
            "QuestionText 3",
            "Correct Answer 3",
            "Incorrect Answer 3 - 1",
            "Incorrect Answer 3 - 2",
            "Incorrect Answer 3 - 3"
        ),
        QuestionModel(
            4,
            "QuestionText 4",
            "Correct Answer 4",
            "Incorrect Answer 4 - 1",
            "Incorrect Answer 4 - 2",
            "Incorrect Answer 4 - 3"
        ),
        QuestionModel(
            5,
            "QuestionText 5",
            "Correct Answer 5",
            "Incorrect Answer 5 - 1",
            "Incorrect Answer 5 - 2",
            "Incorrect Answer 5 - 3"
        ),
        QuestionModel(
            6,
            "QuestionText 6",
            "Correct Answer 6",
            "Incorrect Answer 6 - 1",
            "Incorrect Answer 6 - 2",
            "Incorrect Answer 6 - 3"
        ),
        QuestionModel(
            7,
            "QuestionText 7",
            "Correct Answer 7",
            "Incorrect Answer 7 - 1",
            "Incorrect Answer 7 - 2",
            "Incorrect Answer 7 - 3"
        ),
    )
        return listQuestions
    }
    fun getResult(newStatistic: Int):String{
        val oldStatistic= 1
        if (newStatistic>subcategoryModel.statisticEasy)
        val result = ""
        return result
    }

}