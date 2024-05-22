package com.example.roomdbwithapicall.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.roomdbwithapicall.activity.MainActivity
import com.example.roomdbwithapicall.adapters.UserAdapter
import com.example.roomdbwithapicall.databinding.FragmentUserListBinding
import com.example.roomdbwithapicall.viewmodels.UserViewModel

class UserListFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()
    private val userAdapter: UserAdapter? = null

    private var _binding: FragmentUserListBinding? = null
    private val b get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return b.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startActivity(Intent(requireActivity(), MainActivity::class.java))
        requireActivity().finish()
        initView()
        viewListener()
        getViewModel()
    }

    private fun initView() {
        b.rvUserList.adapter = userAdapter
    }

    private fun viewListener() {
    }

    private fun getViewModel() {
        userViewModel.fetchUserDetails()
    }

}