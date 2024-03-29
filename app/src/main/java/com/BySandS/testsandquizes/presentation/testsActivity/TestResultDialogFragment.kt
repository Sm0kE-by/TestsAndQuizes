package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.TestResultDialogFragmentBinding
import kotlin.properties.Delegates.notNull

private const val TAG = "AAA"

class TestResultDialogFragment : DialogFragment(), View.OnClickListener {

    private lateinit var binding: TestResultDialogFragmentBinding
    private var titleText by notNull<String>()
    private var statistic by notNull<Int>()
    private var correctAnswer by notNull<Int>()
    private var quantityOfQuestion by notNull<Int>()
    private var description by notNull<String>()

    companion object {

        const val KEY_SUBTITLE = "KEY_SUBTITLE"
        const val KEY_STATISTIC = "KEY_STATISTIC"
        const val KEY_CORRECT_ANSWER = "KEY_CORRECT_ANSWER"
        const val KEY_QUANTITY_OF_QUESTION = "KEY_QUANTITY_OF_QUESTION"

        const val REQUEST_CODE = "KEY_REQUEST_CODE"
        const val BUTTON_RESULT = "BUTTON_RESULT"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestResultDialogFragmentBinding.inflate(inflater, container, false)
        statistic = requireArguments().getInt(KEY_STATISTIC)
        correctAnswer = requireArguments().getInt(KEY_CORRECT_ANSWER)
        quantityOfQuestion = requireArguments().getInt(KEY_QUANTITY_OF_QUESTION)
        description = requireArguments().getString(KEY_SUBTITLE)!!.toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btContinue.setOnClickListener(this)
        binding.btTryAgain.setOnClickListener(this)
        binding.btShareResult.setOnClickListener(this)
        setupView()

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView() {
        if (statistic > 33) binding.tvTitle.text = getString(R.string.congratulations)
        else binding.tvTitle.text = getString(R.string.regret)
        binding.tvDescription.text = getString(
            R.string.result_desc, correctAnswer.toString(),
            quantityOfQuestion.toString(), statistic.toString(), description
        )
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btContinue.id -> {
                Log.i(TAG, "btContinue ->>> Continue")
                val num = 1
                parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(BUTTON_RESULT to num))
                dismiss()
            }
            binding.btTryAgain.id -> {
                val num = 2
                parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(BUTTON_RESULT to num))
                dismiss()
            }
            binding.btShareResult.id -> {
                Log.i(TAG, "btShareResult ->>> Shared RESULT")
                dismiss()
            }
        }
    }
}