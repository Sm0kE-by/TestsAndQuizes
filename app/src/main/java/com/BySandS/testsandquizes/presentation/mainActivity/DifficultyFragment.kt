package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.BySandS.testsandquizes.databinding.DefficultyFragmentBinding

class DifficultyFragment : Fragment() {

    private lateinit var binding: DefficultyFragmentBinding

    //подключаем VM фрагмента
    private val difficulty: DifficultyFragmentViewModel by lazy {
        ViewModelProvider(this).get(DifficultyFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DefficultyFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
    }

    companion object {
        @JvmStatic
        fun newInstance() = DifficultyFragment()
    }

    private fun updateUI() = with(binding) {

        val subcategoryModel = difficulty.getCategory()
        val quantityOfQuestion = difficulty.getQuantityOfQuestion()
        //получаю из БД кол-во вопросов
        tvQuantityQuestionEasy.text = quantityOfQuestion.easyQuantity.toString()
        tvQuantityQuestionNorm.text = quantityOfQuestion.normQuantity.toString()
        tvQuantityQuestionHard.text = quantityOfQuestion.hardQuantity.toString()
        // получаю из БД статистика
        tvBestResultEasyNamber.text = subcategoryModel.statisticEasyPercent.toString()
        tvBestResultNormNamber.text = subcategoryModel.statisticNormPercent.toString()
        tvBestResultHardNamber.text = subcategoryModel.statisticHardPercent.toString()
        tvNameSubcategory.text = subcategoryModel.subcategoryName
    }
}