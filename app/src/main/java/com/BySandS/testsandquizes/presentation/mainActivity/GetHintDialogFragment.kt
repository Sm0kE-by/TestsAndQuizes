package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.GetHintDialogFragmentBinding
import java.util.Calendar
import java.util.Date
import kotlin.properties.Delegates

class GetHintDialogFragment : DialogFragment(), View.OnClickListener {

    private lateinit var binding: GetHintDialogFragmentBinding
    private var quantityOfHint by Delegates.notNull<Int>()
    private lateinit var countDownTimer: CountDownTimer

    private lateinit var oldTime: Date
    private lateinit var currentTime: Date
    private var watchAdvertisingToday by Delegates.notNull<Int>()

    companion object {
        const val KEY_QUANTITY = "KEY_QUANTITY"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GetHintDialogFragmentBinding.inflate(inflater, container, false)
        // quantity = requireArguments().getInt(KEY_QUANTITY)
        quantityOfHint = 1
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPositive.setOnClickListener(this)
        binding.btnNegative.setOnClickListener(this)
        binding.btnAdvertising.setOnClickListener(this)
        setupView()
        startNewTimer222()
        checkingTimeUntilHint()
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
        binding.tvQuantity.text = getString(R.string.from_hint, quantityOfHint.toString())
    }

    private fun checkingTimeUntilHint() {
        currentTime = Calendar.getInstance().time

        if (oldTime.time > currentTime.time) {
            val different = oldTime.time - currentTime.time
            printDifferenceDateForHours(different)
        } else {
            if (!binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = true
            printDifferenceDateForHours(0L)
        }
    }

    private fun startNewTimer222() {
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, 1)
        oldTime = cal.time
        //milliseconds
        // var different = datePlus12Hours.time - currentTime.time
    }

    private fun startNewTimer() {
        countDownTimer.cancel()
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, 1)
        oldTime = cal.time
//        val datePlus12Hours: Date = cal.time
//        //milliseconds
//        var different = datePlus12Hours.time - currentTime.time

        if (binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = false
        // Нужно сохранить новое время
        checkingTimeUntilHint()

    }

    private fun printDifferenceDateForHours(time: Long) {

        countDownTimer = object : CountDownTimer(time, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var diff = millisUntilFinished
                val secondsInMilli: Long = 1000
                val minutesInMilli = secondsInMilli * 60
                val hoursInMilli = minutesInMilli * 60

                val elapsedHours = diff / hoursInMilli
                diff %= hoursInMilli

                val elapsedMinutes = diff / minutesInMilli
                diff %= minutesInMilli

                val elapsedSeconds = diff / secondsInMilli

                fun getSeconds(seconds: Long): String {
                    if (seconds < 10) return "0$seconds"
                    return seconds.toString()
                }

                var text = "${getSeconds(elapsedHours)} : ${getSeconds(elapsedMinutes)} : ${
                    getSeconds(elapsedSeconds)
                }"
                binding.tvTimer.text = text

            }

            override fun onFinish() {
                binding.tvTimer.text = "00 : 00 : 00"
                if (!binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = true
            }
        }.start()
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            binding.btnPositive.id -> {
                if (binding.btnPositive.isEnabled) {
                    if (quantityOfHint != 2) {
                        quantityOfHint++
                        startNewTimer()
                    } else {
                        Toast.makeText(
                            context, getString(R.string.hint_warning_max_hint), Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }
            }

            binding.btnNegative.id -> {
                findNavController().popBackStack()
            }
//Загрузка рекламы
            binding.btnAdvertising.id -> {
                //delete
                watchAdvertisingToday = 1
                val advertising = true
                if (watchAdvertisingToday != 2) {
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