package com.BySandS.testsandquizes

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
    private val testListViewModel: TestsListViewModel by lazy {
        ViewModelProvider(this).get(TestsListViewModel::class.java)
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

        val difficultyModel = testListViewModel.difficultyNameModel
        val categoryModel = testListViewModel.categoryModel

        tvDiffenetlyNameEasy.text = difficultyModel?.difficulty
        tvDiffenetlyNameNorm.text = difficultyModel?.difficulty
        tvDiffenetlyNameHard.text = difficultyModel?.difficulty
        tvQuantityEasy.text = difficultyModel?.quantityQuestion
        tvQuantityNorm.text = difficultyModel?.quantityQuestion
        tvQuantityHard.text = difficultyModel?.quantityQuestion
        tvBestResultEasy.text = difficultyModel?.bestResult
        tvBestResultNorm.text = difficultyModel?.bestResult
        tvBestResultHard.text = difficultyModel?.bestResult
        tvEasy.text = difficultyModel?.easy
        tvNorm.text = difficultyModel?.norm
        tvHard.text = difficultyModel?.hard
        tvQuantityQuestionEasy.text = difficultyModel?.quantityQuestionEasy.toString()
        tvQuantityQuestionNorm.text = difficultyModel?.quantityQuestionNorm.toString()
        tvQuantityQuestionHard.text = difficultyModel?.quantityQuestionHard.toString()
        tvBestResultEasyNamber.text = categoryModel?.easyPercent.toString()
        tvBestResultNormNamber.text = categoryModel?.normPercent.toString()
        tvBestResultHardNamber.text = categoryModel?.hardPercent.toString()
        tvNameCategory.text = categoryModel?.name
    }
}