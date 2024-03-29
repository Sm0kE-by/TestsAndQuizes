package com.BySandS.testsandquizes.presentation.testsActivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R

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