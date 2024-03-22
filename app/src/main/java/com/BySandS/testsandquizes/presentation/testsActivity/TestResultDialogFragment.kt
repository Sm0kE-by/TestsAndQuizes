package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.BySandS.testsandquizes.R

class TestResultDialogFragment: DialogFragment() {

//    companion object {
//
//        const val TAG = "SimpleDialog"
//
//        private const val KEY_TITLE = "KEY_TITLE"
//        private const val KEY_SUBTITLE = "KEY_SUBTITLE"
//
//        fun newInstance(title: String, subTitle: String): TestResultDialogFragment {
//            val args = Bundle()
//            args.putString(KEY_TITLE, title)
//            args.putString(KEY_SUBTITLE, subTitle)
//            val fragment = TestResultDialogFragment()
//            fragment.arguments = args
//            return fragment
//        }
//
//    }
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.test_result_dialog_fragment, container, false)
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupView(view)
//        setupClickListeners(view)
//    }
//
//    override fun onStart() {
//        super.onStart()
//        dialog?.window?.setLayout(
//            WindowManager.LayoutParams.MATCH_PARENT,
//            WindowManager.LayoutParams.WRAP_CONTENT
//        )
//    }
//
//    private fun setupView(view: View) {
//        view. = arguments?.getString(KEY_TITLE)
//        view.tvSubTitle.text = arguments?.getString(KEY_SUBTITLE)
//    }
//
//    private fun setupClickListeners(view: View) {
//        view.btnPositive.setOnClickListener {
//            // TODO: Do some task here
//            dismiss()
//        }
//        view.btnNegative.setOnClickListener {
//            // TODO: Do some task here
//            dismiss()
//        }
//    }

}