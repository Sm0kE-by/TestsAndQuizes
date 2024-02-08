package com.BySandS.testsandquizes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.BySandS.testsandquizes.DataBase.AppDatabase
import com.BySandS.testsandquizes.DataBase.TestsRepository
import com.BySandS.testsandquizes.DataBase.entity.SubcategoryDbEntity
import com.BySandS.testsandquizes.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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