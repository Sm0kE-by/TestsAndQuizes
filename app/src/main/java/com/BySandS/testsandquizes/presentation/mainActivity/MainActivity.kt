package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.BySandS.testsandquizes.R


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
        }
    }

}