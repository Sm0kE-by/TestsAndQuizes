package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.GetHintDialogFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar
import java.util.Date
import kotlin.properties.Delegates

class GetHintDialogFragment : DialogFragment(), View.OnClickListener {

    private val getHintVM by viewModel<GetHintDialogFragmentViewModel>()

    private lateinit var binding: GetHintDialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GetHintDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPositive.setOnClickListener(this)
        binding.btnNegative.setOnClickListener(this)
        binding.btnAdvertising.setOnClickListener(this)
        getHintVM.textTimer.observe(viewLifecycleOwner, Observer { text ->
            text?.let {
                setupView()
            }
        })
        checkingTimeUntilHint(getHintVM.oldTime.value!!, getHintVM.currentTime.value!!)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView() {
        if (binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = false
        binding.tvQuantity.text = getString(R.string.from_hint, getHintVM.quantityOfHint.toString())
    }

    private fun checkingTimeUntilHint(oldTime: Date, currentTime: Date) {

        if (oldTime.time > currentTime.time) {
            val different = oldTime.time - currentTime.time
            getHintVM.printDifferenceDateForHours(different)
        } else {
            if (!binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = true
            getHintVM.printDifferenceDateForHours(0L)
        }
    }

    private fun startNewTimer() {
        getHintVM.startNewTimer()

        if (binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = false
        // Нужно сохранить новое время
        checkingTimeUntilHint(getHintVM.oldTime.value!!, getHintVM.currentTime.value!!)

    }


    override fun onClick(v: View?): Unit = with(binding) {
        when (v?.id) {

            btnPositive.id -> {
                if (btnPositive.isEnabled) {
                    if (getHintVM.checkQuantityOfHint()) {
                        startNewTimer()
                    } else {
                        Toast.makeText(
                            context, getString(R.string.hint_warning_max_hint), Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }
            }

           btnNegative.id -> {
                findNavController().popBackStack()
            }
//Загрузка рекламы
            btnAdvertising.id -> {

               val advertising = true
                if (getHintVM.watchAdvertisingToday.value != 2) {
                    if (advertising) {
                        Toast.makeText(
                            context, "Идет показ рекламы", Toast.LENGTH_LONG
                        ).show()
                        quantityOfHint++
                        startNewTimer()
                    } else {
                        Toast.makeText(
                            context,
                            "Подождите несколько секунд пока реклама загрузиться",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    watchAdvertisingToday++
                } else {
                    Toast.makeText(
                        context,
                        "Превышен максимальный дневной лимит бесплатных пополнений",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}