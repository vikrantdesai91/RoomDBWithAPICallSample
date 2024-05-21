package com.example.roomdbwithapicall.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomdbwithapicall.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {

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

//        initView()
//        viewListener()
//        getViewModel()
    }

}