package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.BySandS.testsandquizes.R
import java.util.Calendar

private const val TAG = "AAA"

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.holder)
        if (currentFragment == null) {
            val fragment = MainMenuFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.holder, fragment)
                .commit()



//        timeToMatch[Calendar.HOUR_OF_DAY] = +1
//        timeToMatch[Calendar.MINUTE] = minuteToMatch

//            when {
//                currentTime == timeToMatch -> // the times are equals
//                    currentTime < timeToMatch -> // currentTime is before timeToMatch
//                currentTime > timeToMatch -> // currentTime is after timeToMatch
//            }


        }
    }

}