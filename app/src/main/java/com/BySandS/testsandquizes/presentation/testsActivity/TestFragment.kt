package com.BySandS.testsandquizes.presentation.testsActivity

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.BySandS.testsandquizes.databinding.TestFragmentBinding

class TestFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: TestFragmentBinding

    //подключаем VM фрагмента
    private val testVM: TestFragmentViewModel by lazy {
        ViewModelProvider(this).get(TestFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btAnswer1.setOnClickListener(this@TestFragment)
        binding.btAnswer2.setOnClickListener(this@TestFragment)
        binding.btAnswer3.setOnClickListener(this@TestFragment)
        binding.btAnswer4.setOnClickListener(this@TestFragment)
        startTest()
    }

    companion object {
        fun newInstance() = TestFragment()
    }

    private fun startTest() = with(binding) {
        if (testVM.quantityOfQuestion != testVM.listQuestions.size) {
            val quantityOfQuestion = testVM.quantityOfQuestion
            val question: com.BySandS.testsandquizes.domain.tests.models.QuestionModel = testVM.listQuestions[quantityOfQuestion]

            val quantityQuestionsNumbers = quantityOfQuestion + 1
            //Возможно надо обернуть в LiveData!!!
            val quantityOfHint = testVM.quantityOfHint
            val quantityOfHints = "$quantityOfHint из 3"

            tvHintNumber.text = quantityOfHints
            //русский текст!!!
            val questionsNumbers = "$quantityQuestionsNumbers из ${testVM.listQuestions.size}"
            tvQuestion.text = question.questionText
            // Пока не перемешиваем ответы!!!
            btAnswer1.text = question.correctAnswer
            btAnswer2.text = question.incorrectAnswer1
            btAnswer3.text = question.incorrectAnswer2
            btAnswer4.text = question.incorrectAnswer3

            tvQuestionsNumbers.text = questionsNumbers
        } else {
            /**
             * Загрузка результата
             */
            Toast.makeText(
                activity?.applicationContext,
                "Test Completed\n Correct - ${testVM.quantityCorrectAnswer}\n Incorrect - ${testVM.quantityIncorrectAnswer}",
                Toast.LENGTH_LONG
            ).show()
            testVM.calculateTheResult()
        }
    }

    override fun onClick(v: View?): Unit =
        with(binding) {
            if (testVM.quantityOfQuestion != testVM.listQuestions.size) {
                when (v?.id) {
                    btAnswer1.id -> checkingAnswer(btAnswer1.text.toString())
                    btAnswer2.id -> checkingAnswer(btAnswer2.text.toString())
                    btAnswer3.id -> checkingAnswer(btAnswer3.text.toString())
                    btAnswer4.id -> checkingAnswer(btAnswer4.text.toString())
                }
            }
        }

    private fun checkingAnswer(answerText: String) {
        if (answerText == testVM.listQuestions[testVM.quantityOfQuestion].correctAnswer) {
            testVM.quantityCorrectAnswer++
        } else testVM.quantityIncorrectAnswer++
        testVM.quantityOfQuestion++
        startTest()
    }
}