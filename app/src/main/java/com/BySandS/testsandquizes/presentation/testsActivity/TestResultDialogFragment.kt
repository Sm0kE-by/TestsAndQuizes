package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.BySandS.testsandquizes.R

class TestResultDialogFragment: DialogFragment() {

    val TAG: String = TestResultDialogFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.test_result_dialog_fragment, container, false)

        return view
    }

}