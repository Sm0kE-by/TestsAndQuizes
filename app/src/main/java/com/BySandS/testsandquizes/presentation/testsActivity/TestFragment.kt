package com.BySandS.testsandquizes.presentation.testsActivity

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.DefficultyFragmentBinding
import com.BySandS.testsandquizes.presentation.mainActivity.DifficultyFragmentViewModel

class TestFragment : Fragment() {

    private lateinit var binding: DefficultyFragmentBinding

    //подключаем VM фрагмента
    private val difficulty: TestFragmentViewModel by lazy {
        ViewModelProvider(this).get(TestFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.test_fragment, container, false)
    }


    companion object {
        fun newInstance() = TestFragment()
    }
}