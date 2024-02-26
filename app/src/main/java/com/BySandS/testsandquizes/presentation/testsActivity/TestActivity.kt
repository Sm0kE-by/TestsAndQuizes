package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.presentation.mainActivity.MainMenuFragment

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.testHolder)
        if (currentFragment == null) {
            val fragment = TestFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.testHolder, fragment)
                .commit()
        }
    }
}