package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.BySandS.testsandquizes.databinding.TestFragmentBinding
import com.BySandS.testsandquizes.domain.tests.models.QuantityOfQuestionModel
import com.BySandS.testsandquizes.domain.tests.models.QuestionModel
import org.koin.androidx.viewmodel.ext.android.viewModel
private const val TAG = "AAA"
class TestFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: TestFragmentBinding

    //подключаем VM фрагмента
    private val testVM by viewModel<TestFragmentViewModel>()

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
        testVM.quantityOfHint.observe(
            viewLifecycleOwner, Observer { it ->
                it?.let {
                    testVM.question.observe(viewLifecycleOwner, Observer { question ->
                        question?.let {
                            showQuestion(
                                question = question
                            )
                        }
                    })
                }
            }
        )
    }


    companion object {
        fun newInstance() = TestFragment()
    }

    private fun showQuestion(question: QuestionModel) = with(binding) {
        Log.i(TAG, "------------------------------------------")
        //Hint deleted!!!
        val quantityOfHints = "${testVM.quantityOfHint.value} из 3"
        tvHintNumber.text = quantityOfHints
        //русский текст!!!
        // ПРОВЕРИТЬ!!!
        val questionsNumbers = "${testVM.quantityOfQuestion.value!!+1} из ${testVM.listQuestions.size}"
        tvQuestion.text = question.questionText
        // Пока не перемешиваем ответы!!!
        btAnswer1.text = question.correctAnswer
        btAnswer2.text = question.incorrectAnswer1
        btAnswer3.text = question.incorrectAnswer2
        btAnswer4.text = question.incorrectAnswer3

        tvQuestionsNumbers.text = questionsNumbers
    }

    override fun onClick(v: View?): Unit =
        with(binding) {
            when (v?.id) {
                btAnswer1.id -> testVM.checkingAnswer(btAnswer1.text.toString())
                btAnswer2.id -> testVM.checkingAnswer(btAnswer2.text.toString())
                btAnswer3.id -> testVM.checkingAnswer(btAnswer3.text.toString())
                btAnswer4.id -> testVM.checkingAnswer(btAnswer4.text.toString())
            }
        }
}