package com.example.roomdbwithapicall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdbwithapicall.R
import com.example.roomdbwithapicall.databinding.FragmentUserEditBinding

class UserEditFragment : Fragment() {

    private var _binding: FragmentUserEditBinding? = null
    private val b get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserEditBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        initView()
//        viewListener()
//        getViewModel()
    }
}