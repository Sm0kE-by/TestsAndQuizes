package com.BySandS.testsandquizes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.BySandS.testsandquizes.databinding.MainMenuFragmentBinding

class MainMenuFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: MainMenuFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainMenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        bTests.setOnClickListener(this@MainMenuFragment)
        bQuizzes.setOnClickListener(this@MainMenuFragment)
        bPhrase.setOnClickListener(this@MainMenuFragment)
        bHelpDev.setOnClickListener(this@MainMenuFragment)
        bSettings.setOnClickListener(this@MainMenuFragment)
        bExit.setOnClickListener(this@MainMenuFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainMenuFragment()
    }

    override fun onClick(v: View?): Unit = with(binding) {
        when (v?.id) {
            bTests.id -> (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.holder, CategoriesFragment.newInstance()).commit()

            bQuizzes.id -> Toast.makeText(
                activity?.applicationContext,
                "Quizzes",
                Toast.LENGTH_LONG
            )
                .show()

            bPhrase.id -> Toast.makeText(activity?.applicationContext, "Phrase", Toast.LENGTH_LONG)
                .show()

            bHelpDev.id -> Toast.makeText(
                activity?.applicationContext,
                "HelpDev",
                Toast.LENGTH_LONG
            )
                .show()

            bSettings.id -> Toast.makeText(
                activity?.applicationContext,
                "Settings",
                Toast.LENGTH_LONG
            )
                .show()

            bExit.id -> Toast.makeText(activity?.applicationContext, "Exit", Toast.LENGTH_LONG)
                .show()

            else -> {}

        }
    }
}