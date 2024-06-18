package com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.AdvertisingTodayModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.OldTimeModel
import com.BySandS.testsandquizes.domain.allData.models.mainMenu.QuantityOfHintModel
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveAdvertisingParam
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveOldTimeParam
import com.BySandS.testsandquizes.domain.allData.models.getHint.param.SaveQuantityOfHintParam
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetAdvertisingTodayUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetOldTimeUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.GetQuantityOfHintUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.SaveAdvertisingTodayUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.SaveOldTimeUseCase
import com.BySandS.testsandquizes.domain.allData.useCase.getHint.SaveQuantityOfHintUseCase
import java.util.Calendar
import java.util.Date

private const val TAG = "AAA"

class GetHintDialogFragmentViewModel(
    private val getAdvertisingTodayUseCase: GetAdvertisingTodayUseCase,
    private val getOldTimeUseCase: GetOldTimeUseCase,
    private val getQuantityOfHintUseCase: GetQuantityOfHintUseCase,
    private val saveAdvertisingTodayUseCase: SaveAdvertisingTodayUseCase,
    private val saveOldTimeUseCase: SaveOldTimeUseCase,
    private val saveQuantityOfHintUseCase: SaveQuantityOfHintUseCase
) : ViewModel() {

    private lateinit var countDownTimer: CountDownTimer

    private var currentTimeMutable = MutableLiveData<Date>()
    private val quantityOfHintMutable = MutableLiveData<QuantityOfHintModel>()
    private val oldTimeMutable = MutableLiveData<OldTimeModel>()
    private var watchAdvertisingTodayMutable = MutableLiveData<AdvertisingTodayModel>()
    private var textTimerMutable = MutableLiveData<String>()
    private var btnPositiveIsEnabledMutable = MutableLiveData<Boolean>()

    private val currentTime: LiveData<Date> = currentTimeMutable
    val quantityOfHint: LiveData<QuantityOfHintModel> = quantityOfHintMutable
    private val oldTime: LiveData<OldTimeModel> = oldTimeMutable
    var watchAdvertisingToday: LiveData<AdvertisingTodayModel> = watchAdvertisingTodayMutable
    var textTimer: LiveData<String> = textTimerMutable
    var btnPositiveIsEnabled: LiveData<Boolean> = btnPositiveIsEnabledMutable

    init {
        btnPositiveIsEnabledMutable.value = false
        currentTimeMutable.value = Calendar.getInstance().time
        refreshQuantityOfHint()
        oldTimeMutable.value = getOldTimeUseCase.execute()
        Log.i(TAG, "oldTime => ${oldTime.value?.oldTime!!}")
        watchAdvertisingTodayMutable.value = getAdvertisingTodayUseCase.execute()
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
                textTimerMutable.value = "00 : 00 : 00"
                buttonPositiveIsEnabled(true)
            }
        }.start()
    }

    /**
     * Проверяем, если старое время с таймера больше текущего (таймер не завершился) -
     * берем полученную разницу и запускаем отображение таймера
     */
    fun checkingTimeUntilHint() {
        Log.i(TAG, "oldTime => ${oldTime.value?.oldTime!!}")
        Log.i(TAG, "currentTime => ${currentTime.value?.time!!}")
        if (oldTime.value?.oldTime!! > currentTime.value?.time!!) {
            val different = oldTime.value?.oldTime!! - currentTime.value?.time!!
            printDifferenceDateForHours(different)
        } else {
            printDifferenceDateForHours(0L)
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
        cal.add(Calendar.SECOND, 10)
        currentTimeMutable.value = Calendar.getInstance().time
        oldTimeMutable.value?.oldTime = cal.timeInMillis

        buttonPositiveIsEnabled(false)
        val saveOldTimeParam = SaveOldTimeParam(time = oldTime.value!!.oldTime)
        saveOldTimeUseCase.execute(saveOldTimeParam = saveOldTimeParam)
        checkingTimeUntilHint()
    }

    fun increaseQuantityOfHint() {
        if (quantityOfHint.value?.quantity != 2) {
            saveQuantityOfHintUseCase.execute(
                saveQuantityOfHintParam = SaveQuantityOfHintParam(
                    quantity = quantityOfHintMutable.value!!.quantity.plus(1)
                )
            )
            refreshQuantityOfHint()
            startNewTimer()
        }
    }

    fun increaseWatchAdvertisingToday() {
        if (watchAdvertisingToday.value?.quantity != 2) {
            saveAdvertisingTodayUseCase.execute(
                saveAdvertisingParam = SaveAdvertisingParam(
                    quantity = watchAdvertisingTodayMutable.value!!.quantity.plus(1),
                    date = Calendar.getInstance().timeInMillis
                )
            )
           refreshAdvertisingToday()
        }
    }

    /**
     * Проверить на несовпадение вкл кнопок
     */
    private fun buttonPositiveIsEnabled(isEnabled: Boolean) {
        if (isEnabled && !btnPositiveIsEnabled.value!!) btnPositiveIsEnabledMutable.value = true
        else if (!isEnabled && btnPositiveIsEnabled.value!!) btnPositiveIsEnabledMutable.value =
            false
    }

    private fun refreshAdvertisingToday() {
        watchAdvertisingTodayMutable.value = getAdvertisingTodayUseCase.execute()
    }

    private fun refreshQuantityOfHint() {
        quantityOfHintMutable.value = getQuantityOfHintUseCase.execute()
    }
}