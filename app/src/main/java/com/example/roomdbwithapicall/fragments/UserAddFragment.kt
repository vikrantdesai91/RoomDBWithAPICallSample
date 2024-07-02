package com.example.roomdbwithapicall.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdbwithapicall.R
import com.example.roomdbwithapicall.databinding.FragmentUserAddBinding
import com.example.roomdbwithapicall.local.RoomDBHelper
import com.example.roomdbwithapicall.model.UsersModel
import com.example.roomdbwithapicall.viewmodels.UserViewModel
import com.example.sample.local.UserDao

class UserAddFragment : Fragment() {

    private var _binding: FragmentUserAddBinding? = null
    private val b get() = _binding!!

    private var userDao: UserDao? = null
    private val userListViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        userListViewModel.init(requireContext())
        _binding = FragmentUserAddBinding.inflate(inflater, container, false)
        return b.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userDao = RoomDBHelper.DatabaseClient.getDatabase(requireContext()).userDao()

        //initView()
        viewListener()
        //getViewModel()
    }

    private fun viewListener() {
        b.btnAdd.setOnClickListener {
            userListViewModel.addUser(
                UsersModel.User(
                    null, // id will be auto-generated
                    b.tietFirstName.text.toString(),
                    null,
                    b.tietLastName.text.toString(),
                    b.tietPhone.text.toString())
            )
            findNavController().navigateUp()
        }

        b.btnCancle.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}