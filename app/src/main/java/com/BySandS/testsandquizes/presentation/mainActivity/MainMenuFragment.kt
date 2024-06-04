package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.MainMenuFragmentBinding
import com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments.AvatarDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenuFragment : Fragment(), View.OnClickListener {

    private val mainMenuVM by viewModel<MainMenuViewModel>()
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

        avatarIV.setOnClickListener(this@MainMenuFragment)
        gemsIButton.setOnClickListener(this@MainMenuFragment)
        hintIButton.setOnClickListener(this@MainMenuFragment)
        prestigeIButton.setOnClickListener(this@MainMenuFragment)

        settingsImageButton.setOnClickListener(this@MainMenuFragment)

        bTests.setOnClickListener(this@MainMenuFragment)
        bQuizzes.setOnClickListener(this@MainMenuFragment)
        bSurvival.setOnClickListener(this@MainMenuFragment)
        bPrestige.setOnClickListener(this@MainMenuFragment)
        bMiniTests.setOnClickListener(this@MainMenuFragment)
        bShop.setOnClickListener(this@MainMenuFragment)
        bExit.setOnClickListener(this@MainMenuFragment)

        mainMenuVM.gems.observe(viewLifecycleOwner, Observer { gems ->
            gems?.let {
                binding.gemsTV.text = gems.gems.toString()
                //binding.gemsTV.text = mainMenuVM.gems.value?.gems.toString()
            }
        })
        mainMenuVM.quantityOfHint.observe(viewLifecycleOwner, Observer { hint ->
            hint?.let {
                binding.hintTV.text = getString(R.string.from_hint,hint.quantity.toString())
            }
        })
        mainMenuVM.prestige.observe(viewLifecycleOwner, Observer { prestige ->
            prestige?.let {
                binding.prestigeTV.text = prestige.quantity.toString()
            }
        })
        mainMenuVM.gameCompletionPercentage.observe(viewLifecycleOwner, Observer { gameCompletionPercentage ->
            gameCompletionPercentage?.let {
                binding.gameCompletionPercentageTV.text = gameCompletionPercentage.percentGameCompletion.toString()
            }
        })
        mainMenuVM.playerName.observe(viewLifecycleOwner, Observer { playerName ->
            playerName?.let {
                binding.playerNameTV.text = playerName.playerName
            }
        })
        mainMenuVM.avatarIcon.observe(viewLifecycleOwner, Observer { avatarIcon ->
            avatarIcon?.let {
                setAvatar(avatarIcon.avatarIcon.toString())
            }
        })


        parentFragmentManager.setFragmentResultListener(
            AvatarDialogFragment.AVATAR_REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val clickDone = data.getString(AvatarDialogFragment.AVATAR_BUTTON_DONE)
            setAvatar(clickDone!!)
        }
      //  TODO("Принять количество подсказок")
        parentFragmentManager.setFragmentResultListener(
            AvatarDialogFragment.AVATAR_REQUEST_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val clickDone = data.getString(AvatarDialogFragment.AVATAR_BUTTON_DONE)
            setAvatar(clickDone!!)
        }
    }

    //Не отрисовывает фрагмент заново
    override fun onResume() {
        super.onResume()
        mainMenuVM.quantityOfHint.observe(viewLifecycleOwner, Observer { hint ->
            hint?.let {
                binding.hintTV.text = getString(R.string.from_hint,hint.quantity.toString())
            }
        })
    }
    companion object {
        @JvmStatic
        fun newInstance() = MainMenuFragment()
    }

    override fun onClick(v: View?): Unit = with(binding) {
        val idCategory: Long
        when (v?.id) {

            bTests.id -> {
                idCategory = 1L
                findNavController().navigate(
                    R.id.action_mainMenuFragment_to_subcategoriesFragment,
                    bundleOf(SubcategoriesFragment.ARG_NAME to idCategory)
                )
            }

            bQuizzes.id -> Toast.makeText(
                activity?.applicationContext, "Quizzes", Toast.LENGTH_LONG
            ).show()

            bSurvival.id -> Toast.makeText(
                activity?.applicationContext, "Survival", Toast.LENGTH_LONG
            ).show()

            bPrestige.id -> Toast.makeText(
                activity?.applicationContext, "Prestige", Toast.LENGTH_LONG
            ).show()

            bShop.id -> Toast.makeText(
                activity?.applicationContext, "Shop", Toast.LENGTH_LONG
            ).show()

            bMiniTests.id ->
                findNavController().navigate(R.id.action_mainMenuFragment_to_get_hint)

            bExit.id -> Toast.makeText(activity?.applicationContext, "Exit", Toast.LENGTH_LONG)
                .show()


            avatarIV.id -> {
                val avatarId = 1L
                findNavController().navigate(R.id.action_mainMenuFragment_to_avatarDialogFragment,
                    bundleOf(AvatarDialogFragment.ID_AVATAR to avatarId)
                )
            }

            gemsIButton.id -> Toast.makeText(
                activity?.applicationContext,
                "Exit",
                Toast.LENGTH_LONG
            )
                .show()

            hintIButton.id -> findNavController().navigate(R.id.action_mainMenuFragment_to_get_hint)

            prestigeIButton.id -> Toast.makeText(
                activity?.applicationContext,
                "Exit",
                Toast.LENGTH_LONG
            )
                .show()

            settingsImageButton.id -> Toast.makeText(
                activity?.applicationContext,
                "Exit",
                Toast.LENGTH_LONG
            )
                .show()


        }
    }

    private fun setAvatar(nameIcon: String) = with(binding) {
        when (nameIcon) {
            "avatar_1.png" -> avatarIV.setImageResource(R.drawable.avatar_1)
            "avatar_2.png" -> avatarIV.setImageResource(R.drawable.avatar_2)
            "avatar_3.png" -> avatarIV.setImageResource(R.drawable.avatar_3)
            "avatar_4.png" -> avatarIV.setImageResource(R.drawable.avatar_4)
            "avatar_5.png" -> avatarIV.setImageResource(R.drawable.avatar_5)
            "avatar_6.png" -> avatarIV.setImageResource(R.drawable.avatar_6)
            "avatar_7.png" -> avatarIV.setImageResource(R.drawable.avatar_7)
            "avatar_8.png" -> avatarIV.setImageResource(R.drawable.avatar_8)
            "avatar_9.png" -> avatarIV.setImageResource(R.drawable.avatar_9)
            "avatar_10.png" -> avatarIV.setImageResource(R.drawable.avatar_10)
        }
    }
}