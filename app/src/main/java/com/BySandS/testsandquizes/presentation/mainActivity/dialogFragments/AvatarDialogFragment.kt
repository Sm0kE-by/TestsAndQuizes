package com.BySandS.testsandquizes.presentation.mainActivity.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.BySandS.testsandquizes.R
import com.BySandS.testsandquizes.databinding.AvatarDialogFragmentBinding
import com.BySandS.testsandquizes.databinding.AvatarItemDialogFragmentBinding
import com.BySandS.testsandquizes.domain.allData.models.AvatarModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "AAA"

class AvatarDialogFragment : DialogFragment(), View.OnClickListener {

    private val avatarVM by viewModel<AvatarDialogFragmentViewModel>()
    private lateinit var binding: AvatarDialogFragmentBinding
    private var adapter = AvatarAdapter(emptyList())

    /**
     * Надуваем Фрагмент
     * Надуваем RV
     * Указываем отображение RV в виде списка(вертикального)
     * Загружаем настройки адаптера
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AvatarDialogFragmentBinding.inflate(inflater, container, false)
        init()
        // idCategory = requireArguments().getLong(ARG_NAME)
        return binding.root
    }

    private fun init() {
        binding.apply {
            avatarRecyclerView.layoutManager = GridLayoutManager(context, 3)
            avatarRecyclerView.adapter = adapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bDone.setOnClickListener(this)
        binding.bClose.setOnClickListener(this)

        updateUI(avatarVM.listAvatars)

        avatarVM.avatarIcon.observe(
            viewLifecycleOwner,
            Observer { avatar ->
                avatar?.let {
                    setAvatarLogo(avatar)
                }
            })
        avatarVM.buttonDonIsEnable.observe(
            viewLifecycleOwner,
            Observer { isClickable ->
                isClickable?.let {
                    binding.bDone.isEnabled = isClickable
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
     * Подключаем лист категорий из VM
     * Подключаем текст описания сложности из VM
     * Подключаем адаптер к RV
     */
    fun updateUI(avatars: List<AvatarModel>) {
        adapter = AvatarAdapter(avatars)
        binding.avatarRecyclerView.adapter = adapter
    }

    companion object {
        const val AVATAR_BUTTON_DONE = "AVATAR_BUTTON_DONE"
        const val AVATAR_REQUEST_CODE = "AVATAR_REQUEST_CODE"
    }

    private inner class AvatarHolder(item: View) : RecyclerView.ViewHolder(item),
        View.OnClickListener {
        val binding = AvatarItemDialogFragmentBinding.bind(item)
        lateinit var avatar: AvatarModel

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            avatarModel: AvatarModel
        ) = with(binding) {
            avatar = avatarModel

            when (avatar.name) {
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
                else -> {}
            }
            when (avatar.open) {
                true -> avatarIconClosed.visibility = View.INVISIBLE
                false -> avatarIconClosed.visibility = View.VISIBLE
            }
        }

        /**
         * Обработка нажатия на фрагмент категории
         */
        override fun onClick(v: View?) {
            avatarVM.setAvatar(avatar)
            if (!avatar.open) avatarVM.setDoneIsEnable(false)
            else avatarVM.setDoneIsEnable(true)
        }
    }

    private inner class AvatarAdapter(
        var avatars: List<AvatarModel>,
    ) :
        RecyclerView.Adapter<AvatarHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.avatar_item_dialog_fragment, parent, false)
            return AvatarHolder(view)
        }

        override fun getItemCount(): Int = avatars.size
        override fun onBindViewHolder(holder: AvatarHolder, position: Int) {
            holder.bind(avatars[position])
        }
    }

    override fun onClick(v: View?): Unit = with(binding) {
        when (v?.id) {
            bDone.id -> {
                val icon = avatarVM.avatarIcon.value?.name
                parentFragmentManager.setFragmentResult(
                    AVATAR_REQUEST_CODE, bundleOf(
                        AVATAR_BUTTON_DONE to icon
                    )
                )
                findNavController().popBackStack()
            }

            bClose.id -> findNavController().popBackStack()
        }
    }

    private fun setAvatarLogo(avatar: AvatarModel) = with(binding) {
        when (avatar.name) {
            "avatar_1.png" -> avatarIcon.setImageResource(R.drawable.avatar_1)
            "avatar_2.png" -> avatarIcon.setImageResource(R.drawable.avatar_2)
            "avatar_3.png" -> avatarIcon.setImageResource(R.drawable.avatar_3)
            "avatar_4.png" -> avatarIcon.setImageResource(R.drawable.avatar_4)
            "avatar_5.png" -> avatarIcon.setImageResource(R.drawable.avatar_5)
            "avatar_6.png" -> avatarIcon.setImageResource(R.drawable.avatar_6)
            "avatar_7.png" -> avatarIcon.setImageResource(R.drawable.avatar_7)
            "avatar_8.png" -> avatarIcon.setImageResource(R.drawable.avatar_8)
            "avatar_9.png" -> avatarIcon.setImageResource(R.drawable.avatar_9)
            "avatar_10.png" -> avatarIcon.setImageResource(R.drawable.avatar_10)
            else -> {}
        }
        avatarType.text = avatar.type
        avatarDesc.text = avatar.description
    }
}