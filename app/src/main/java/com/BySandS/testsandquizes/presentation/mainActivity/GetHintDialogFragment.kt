package com.BySandS.testsandquizes.presentation.mainActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.GetHintDialogFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GetHintDialogFragment : DialogFragment(), View.OnClickListener {

    private val getHintVM by viewModel<GetHintDialogFragmentViewModel>()

    private lateinit var binding: GetHintDialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GetHintDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPositive.setOnClickListener(this)
        binding.btnNegative.setOnClickListener(this)
        binding.btnAdvertising.setOnClickListener(this)

        getHintVM.checkingTimeUntilHint()

        getHintVM.textTimer.observe(viewLifecycleOwner, Observer { text ->
            text?.let {
                binding.tvTimer.text = getHintVM.textTimer.value.toString()
            }
        })
        getHintVM.btnPositiveIsEnabled.observe(viewLifecycleOwner, Observer { btn ->
            btn?.let {
                binding.btnPositive.isEnabled = btn
            }
        })
        getHintVM.quantityOfHint.observe(viewLifecycleOwner, Observer { text ->
            text?.let {
                binding.tvQuantity.text =
                    getString(R.string.from_hint, getHintVM.quantityOfHint.value.toString())
            }
        })

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     *
     */
    override fun onClick(v: View?): Unit = with(binding) {
        when (v?.id) {

            btnPositive.id -> {
                if (btnPositive.isEnabled) {
                    if (getHintVM.quantityOfHint.value != 2) {
                        getHintVM.increaseQuantityOfHint()
                        getHintVM.startNewTimer()
                    } else {
                        Toast.makeText(
                            context, getString(R.string.hint_warning_max_hint), Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }
            }

            btnNegative.id -> {
                findNavController().popBackStack()
            }
//Загрузка рекламы
            btnAdvertising.id -> {

                val advertising = true
                if (getHintVM.watchAdvertisingToday.value != 2 && getHintVM.quantityOfHint.value != 2) {
                    if (advertising) {
                        Toast.makeText(
                            context, "Идет показ рекламы", Toast.LENGTH_LONG
                        ).show()
                        getHintVM.increaseQuantityOfHint()
                        getHintVM.startNewTimer()
                        getHintVM.increaseWatchAdvertisingToday()
                    } else {
                        Toast.makeText(
                            context,
                            getString(R.string.advertising_not_load), Toast.LENGTH_LONG
                        ).show()
                    }
                } else if (getHintVM.watchAdvertisingToday.value == 2) {
                    Toast.makeText(
                        context,
                        getString(R.string.maximum_limit_of_free_top_ups),
                        Toast.LENGTH_LONG
                    ).show()
                } else if (getHintVM.quantityOfHint.value == 2) {
                    Toast.makeText(
                        context,
                        getString(R.string.hint_warning_max_hint),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}