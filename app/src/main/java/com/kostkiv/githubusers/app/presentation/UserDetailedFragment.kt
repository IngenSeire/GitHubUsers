package com.kostkiv.githubusers.app.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.kostkiv.githubusers.R
import com.kostkiv.githubusers.databinding.FragmentUserDetailedBinding
import com.kostkiv.githubusers.domain.UserDetailed

class UserDetailedFragment : Fragment() {

    private var _binding : FragmentUserDetailedBinding? = null
    private val binding : FragmentUserDetailedBinding
    get() = _binding ?: throw RuntimeException("FragmentUserDetailedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userDetailed = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(ARG_USER_DETAILED, UserDetailed::class.java)
                ?: throw RuntimeException("DetailedUser arg == null")
        } else {
            @Suppress("DEPRECATION") arguments?.getParcelable(ARG_USER_DETAILED) as? UserDetailed
                ?: throw RuntimeException("DetailedUser arg == null")
        }
        setupData(userDetailed)
    }

    private fun setupData(userDetailed: UserDetailed) {
        with(binding) {
            with(userDetailed) {
                context?.let {
                    Glide.with(it).load(avatarUrl).into(imageViewAvatar)
                    textViewUsername.text = String.format(getString(R.string.username_label), login)
                    setupTextWithNullCheck(name, textViewName, R.string.name_label)
                    setupTextWithNullCheck(email, textViewEmail, R.string.email_label)
                    setupTextWithNullCheck(organization, textViewOrganization, R.string.organization_label)
                    if(accountCreated != null) {
                        textViewCreated.text = String.format(getString(R.string.created_label), accountCreated.subSequence(0, 10))
                    } else textViewCreated.text = String.format(getString(R.string.created_label), "-")
                    textViewFollowersCount.text = String.format(getString(R.string.followers_count_label), followersCount)
                    textViewFollowingCount.text = String.format(getString(R.string.following_count_label), followingCount)
                }
            }
        }
    }

    private fun setupTextWithNullCheck(data : String?, textView : TextView, labelId : Int) {
        if(data != null) {
            textView.text = String.format(getString(labelId), data)
        } else textView.text = String.format(getString(labelId), "-")
    }

    companion object {
        private const val ARG_USER_DETAILED = "userDetailed"
        @JvmStatic
        fun newInstance(user : UserDetailed) =
            UserDetailedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_USER_DETAILED, user)
                }
            }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}