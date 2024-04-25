package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar
import java.util.Date

private const val TAG = "AAA"
class GetHintDialogFragmentViewModel : ViewModel() {

    private lateinit var countDownTimer: CountDownTimer

    private var currentTimeMutable = MutableLiveData<Date>()
    private val quantityOfHintMutable = MutableLiveData<Int>()
    private val oldTimeMutable = MutableLiveData<Date>()
    private var watchAdvertisingTodayMutable = MutableLiveData<Int>()
    private var textTimerMutable = MutableLiveData<String>()
    private var btnPositiveIsEnabledMutable = MutableLiveData<Boolean>()

    private val currentTime: LiveData<Date> = currentTimeMutable
    val quantityOfHint: LiveData<Int> = quantityOfHintMutable
    private val oldTime: LiveData<Date> = oldTimeMutable
    var watchAdvertisingToday: LiveData<Int> = watchAdvertisingTodayMutable
    var textTimer: LiveData<String> = textTimerMutable
    var btnPositiveIsEnabled: LiveData<Boolean> = btnPositiveIsEnabledMutable

    init {
        btnPositiveIsEnabledMutable.value = false
        currentTimeMutable.value = Calendar.getInstance().time
        Log.i(TAG, " currentTime => ${currentTimeMutable.value}")
        quantityOfHintMutable.value = 0
        initOldTime()
        watchAdvertisingTodayMutable.value = 0
    }

    /**
     * Таймер
     */
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
                textTimerMutable.value = text
            }

            override fun onFinish() {
                // textTimerMutable.value = "00 : 00 : 00"
                buttonPositiveIsEnabledTrue()
            }
        }.start()
    }

    /**
     * Проверяем, если старое время с таймера больше текущего (таймер не завершился) -
     * берем полученную разницу и запускаем отображение таймера
     */
    fun checkingTimeUntilHint() {
        if (oldTime.value?.time!! > currentTime.value?.time!!) {
            val different = oldTime.value?.time!! - currentTime.value?.time!!
            printDifferenceDateForHours(different)
        }
    }

    /**
     * Останавливаем таймер
     * Создаем новый интервал времени добавляя 12 часов и сохраняем значение в oldTime
     * Выключаем кнопку получить
     * Запускаем проверку нового и старого времени
     */
    fun startNewTimer() {
        countDownTimer.cancel()
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, 1)
        currentTimeMutable.value = Calendar.getInstance().time
        oldTimeMutable.value = cal.time

        buttonPositiveIsEnabledFalse()
        // Нужно сохранить новое время
        checkingTimeUntilHint()
    }

    //deleted
    private fun initOldTime() {
        val date = Date()
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MINUTE, 1)
        oldTimeMutable.value = cal.time
        //milliseconds
        // var different = datePlus12Hours.time - currentTime.time
    }

    fun increaseQuantityOfHint() {
        if (quantityOfHint.value != 2) {
            quantityOfHintMutable.value = quantityOfHintMutable.value?.plus(1)
        }
    }

    fun increaseWatchAdvertisingToday() {
        if (watchAdvertisingToday.value != 2) {
            watchAdvertisingTodayMutable.value = watchAdvertisingTodayMutable.value?.plus(1)
        }
    }

    private fun buttonPositiveIsEnabledTrue() {
        if (!btnPositiveIsEnabled.value!!) btnPositiveIsEnabledMutable.value = true
    }

    private fun buttonPositiveIsEnabledFalse() {
        if (btnPositiveIsEnabled.value!!) btnPositiveIsEnabledMutable.value = false
    }
}