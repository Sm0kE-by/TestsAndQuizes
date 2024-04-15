package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar
import java.util.Date

class GetHintDialogFragmentViewModel : ViewModel() {

    private lateinit var countDownTimer: CountDownTimer

    private var currentTimeMutable = MutableLiveData<Date>()
    private val quantityOfHintMutable  = MutableLiveData<Int>()
    private val oldTimeMutable= MutableLiveData<Date>()
    private var watchAdvertisingTodayMutable = MutableLiveData<Int>()
    private var textTimerMutable = MutableLiveData<String>()

    val currentTime : LiveData<Date> = currentTimeMutable
     val quantityOfHint  : LiveData<Int> = quantityOfHintMutable
     val oldTime: LiveData<Date> = oldTimeMutable
     var watchAdvertisingToday : LiveData<Int> = watchAdvertisingTodayMutable
     var textTimer :LiveData<String> = textTimerMutable

    init {

        currentTimeMutable.value = Calendar.getInstance().time
        quantityOfHintMutable.value = 0
        initOldTime()
        watchAdvertisingTodayMutable.value = 0

    }

    fun printDifferenceDateForHours(time: Long) {

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
                textTimerMutable.value = text
            }

            override fun onFinish() {
                textTimerMutable.value = "00 : 00 : 00"
               // if (!binding.btnPositive.isEnabled) binding.btnPositive.isEnabled = true
            }
        }.start()
    }

     fun startNewTimer() {
        countDownTimer.cancel()
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, 1)
        oldTimeMutable.value = cal.time
    }

        private fun initOldTime(){
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, 1)
        oldTimeMutable.value = cal.time
        //milliseconds
        // var different = datePlus12Hours.time - currentTime.time
    }

    fun checkQuantityOfHint(): Boolean{
        if (quantityOfHint.value != 2) {
            quantityOfHintMutable.value =+ 1
            return true
    }
        return false


}