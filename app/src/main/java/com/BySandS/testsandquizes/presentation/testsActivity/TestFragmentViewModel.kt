package com.BySandS.testsandquizes.presentation.testsActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import com.BySandS.testsandquizes.domain.tests.models.ResultTestModel
import com.BySandS.testsandquizes.domain.tests.models.StatisticModel
import com.BySandS.testsandquizes.domain.tests.models.SubcategoryModel
import com.BySandS.testsandquizes.domain.tests.models.param.GetQuestionListParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetResultParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetStatisticParam
import com.BySandS.testsandquizes.domain.tests.models.param.GetSubcategoryParam
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetQuestionListUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestResultUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestStatisticUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.GetTestSubcategoryByIdUseCase
import com.BySandS.testsandquizes.domain.tests.usecase.testActivity.SaveTestStatisticUseCase
import com.BySandS.testsandquizes.presentation.model.TestModelPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "AAA"

class TestFragmentViewModel(
    private val getTestResultUseCase: GetTestResultUseCase,
    private val getQuestionListUseCase: GetQuestionListUseCase,
    private val saveTestStatisticUseCase: SaveTestStatisticUseCase,
    private val getTestStatisticUseCase: GetTestStatisticUseCase,
    private val getTestSubcategoryByIdUseCase: GetTestSubcategoryByIdUseCase
) : ViewModel() {
    private val idSubcategory = TestFragment.idSubcategory
    private val result = MutableLiveData<ResultTestModel>()
    private val static = MutableLiveData<StatisticModel>()
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
    private val questionListMutable = MutableLiveData<List<QuestionModel>>()
    private var quantityOfQuestionMutable = MutableLiveData<Int>(0)
    private var questionMutable =
        MutableLiveData<QuestionModel>()
    private val quantityOfHintMutable = MutableLiveData<Int>()

    val questionList: LiveData<List<QuestionModel>> = questionListMutable
    var quantityOfQuestion: LiveData<Int> = quantityOfQuestionMutable
    var question: LiveData<QuestionModel> = questionMutable
    val quantityOfHint: LiveData<Int> = quantityOfHintMutable

    private var quantityCorrectAnswer = 0

    //Пока вручную, потом буду принимать его на вход
    val testModelPresentation =
        TestModelPresentation(nameSubcategoryId = 1, difficultyId = 1, quantityOfQuestion = 7)
    private var subcategoryModel: SubcategoryModel? = null

    init {


        viewModelScope.launch(Dispatchers.IO) {

            val getSubcategoryParam = GetSubcategoryParam(idSubcategory = idSubcategory)

            subcategoryModel = getTestSubcategoryByIdUseCase.execute(param = getSubcategoryParam)
            Log.i(TAG, "subcategoryModel ->>> $subcategoryModel")
            subcategoryModel.let {
                val getQuestionListParam =
                    GetQuestionListParam(
                        difficultyId = 1,
                        quantityOfQuestions = subcategoryModel!!.quantityOfQuestionsId
                    )
                val getResultParam =
                    GetResultParam(testResultId = subcategoryModel!!.testResultId, difficultyId = 1)
                val getStatisticParam = GetStatisticParam(nameSubcategory = subcategoryModel!!.subcategoryName)


                questionListMutable.postValue(listQuestions)
                questionMutable.postValue(randomAnswerOfQuestion(listQuestions[quantityOfQuestion.value!!]))
                result.postValue(getTestResultUseCase.execute(param = getResultParam))
                static.postValue(getTestStatisticUseCase.execute(param = getStatisticParam))
                quantityOfHintMutable.postValue(2)
            }
        }
    }

    /**
     * Вычисление статистики пройденного теста
     */
    private fun calculateTheResult(): Int {
        //       Log.i(TAG, "Starting fun - calculateTheResult")
        //       Log.i(TAG, "CorrectAnswer = $quantityCorrectAnswer из ${listQuestions.size}")
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
        //       Log.i(TAG, "Starting fun - checkingAnswer")
//        Log.i(
//            TAG,
//            "answerText = $answerText; correctAnswer = ${questionList.value!![quantityOfQuestion].correctAnswer}"
//        )
        if (answerText == questionList.value!![quantityOfQuestion.value!!].correctAnswer) {
            quantityCorrectAnswer++
//            Log.i(TAG, "CorrectAnswer - $answerText")
        } else {
        }
        updateParam()
    }

    private fun updateParam() {
        Log.i(TAG, "Starting fun - updateParam")

        if (quantityOfQuestion.value != listQuestions.size - 1) {
            val num: Int = quantityOfQuestionMutable.value!! + 1
            quantityOfQuestionMutable.value = num
            val question1 = listQuestions[quantityOfQuestionMutable.value!!]
            Log.i(TAG, "$question1")
            Log.i(TAG, "quantityOfQuestion = ${num} listQuestions.size ${listQuestions.size}")
            questionMutable.value = randomAnswerOfQuestion(question1)
        } else {
//            Log.i(TAG, "saveStatistic")
            saveStatistic()
        }
    }

    /**
     * data Class StatisticModel - переменные типа VAR!!!!!!!!!!!!
     * if() в when()!!!!!
     */
    private fun saveStatistic() {
        val newStatistic = calculateTheResult()
        val result = mapToSaveStatistic(static)
        Log.i(TAG, "New Statistic - $newStatistic")
        if (testModelPresentation.difficultyId == 1L && newStatistic > result.easy) result.easy =
            newStatistic
        if (testModelPresentation.difficultyId == 2L && newStatistic > result.norm) result.norm =
            newStatistic
        if (testModelPresentation.difficultyId == 3L && newStatistic > result.hard) result.hard =
            newStatistic

        viewModelScope.launch(Dispatchers.IO) { saveTestStatisticUseCase.execute(result) }
    }

    //Что за !! ????
    private fun mapToSaveStatistic(static: MutableLiveData<StatisticModel>): StatisticModel {
        return StatisticModel(
            id = static.value!!.id,
            nameSubcategory = static.value!!.nameSubcategory,
            easy = static.value!!.easy,
            norm = static.value!!.norm,
            hard = static.value!!.hard
        )
    }
}