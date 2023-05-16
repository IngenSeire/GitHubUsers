package com.kostkiv.githubusers.app.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kostkiv.githubusers.R
import com.kostkiv.githubusers.app.presentation.rv.UsersListAdapter
import org.koin.android.ext.android.inject

class GitHubUsersFragment : Fragment() {

    private val viewModel : UsersViewModel by inject()

    private val recyclerAdapter by lazy { UsersListAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_git_hub_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewUsers)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        observeViewModel()
        recyclerAdapter.onUserClickListener =
            { username -> viewModel.loadDetailedInfoAboutUser(username) }
        recyclerAdapter.onListEnded = {
            viewModel.loadListOfUsers(it)
        }
    }

    private fun observeViewModel() {
        viewModel.usersList.observe(viewLifecycleOwner) {
            if(it.isEmpty()) {
                viewModel.loadListOfUsers(0)
            } else {
                recyclerAdapter.submitList(it)
            }
        }
        viewModel.detailedUserInfo.observe(viewLifecycleOwner) {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.add(R.id.fragment_container_view_main,
                    UserDetailedFragment.newInstance(it))
                ?.addToBackStack(null)
                ?.commit()
        }
        viewModel.connectionError.observe(viewLifecycleOwner) {
            if(it) Toast.makeText(context, getString(R.string.connection_error_toast),
                Toast.LENGTH_LONG).show()
        }
    }
}