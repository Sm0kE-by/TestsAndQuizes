package com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.os.bundleOf
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
                    getString(R.string.from_hint, getHintVM.quantityOfHint.value?.quantity.toString())
            }
        })

    }

    companion object{

        const val BUTTON_CANCEL_POP_BACK_STACK = "BUTTON_CANCEL_POP_BACK_STACK"
        const val REQUEST_CODE = "KEY_REQUEST_CODE"

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
                    if (getHintVM.quantityOfHint.value?.quantity != 2) {
                        getHintVM.increaseQuantityOfHint()
                    } else {
                        Toast.makeText(
                            context, getString(R.string.hint_warning_max_hint), Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }
            }

            btnNegative.id -> {
                val num = 5
                parentFragmentManager.setFragmentResult(
                    REQUEST_CODE, bundleOf(
                        BUTTON_CANCEL_POP_BACK_STACK to num)
                )
                findNavController().popBackStack()
            }

//Загрузка рекламы
            btnAdvertising.id -> {

                val advertising = true
                if (getHintVM.watchAdvertisingToday.value?.quantity != 2 && getHintVM.quantityOfHint.value?.quantity != 2) {
                    if (advertising) {
                        Toast.makeText(
                            context, "Идет показ рекламы", Toast.LENGTH_LONG
                        ).show()
                        getHintVM.increaseQuantityOfHint()
                        getHintVM.increaseWatchAdvertisingToday()
                    } else {
                        Toast.makeText(
                            context,
                            getString(R.string.advertising_not_load), Toast.LENGTH_LONG
                        ).show()
                    }
                } else if (getHintVM.watchAdvertisingToday.value?.quantity == 2) {
                    Toast.makeText(
                        context,
                        getString(R.string.maximum_limit_of_free_top_ups),
                        Toast.LENGTH_LONG
                    ).show()
                } else if (getHintVM.quantityOfHint.value?.quantity == 2) {
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