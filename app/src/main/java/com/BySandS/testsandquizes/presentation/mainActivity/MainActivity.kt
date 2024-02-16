package com.BySandS.testsandquizes.presentation.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.BySandS.testsandquizes.data.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.R


class MainActivity : AppCompatActivity() {

    private var list = emptyList<SubcategoryDbEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        GlobalScope.launch {
//            val testRepository = TestsRepository.get()
//            val list1 = testRepository.getAllSubcategories2()
//
//        }



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