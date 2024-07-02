package com.example.roomdbwithapicall.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.roomdbwithapicall.databinding.FragmentUserEditBinding
import com.example.roomdbwithapicall.local.RoomDBHelper
import com.example.roomdbwithapicall.viewmodels.UserViewModel
import com.example.sample.local.UserDao

class UserEditFragment : Fragment() {

    private var _binding: FragmentUserEditBinding? = null
    private val b get() = _binding!!

    private var firstName: String? = null
    private var lastName: String? = null
    private var profile: String? = null
    private var phone: String? = null
    private var userID: String? = null
    private var userDao: UserDao? = null
    private val userViewModel: UserViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentUserEditBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewListener()
        // getViewModel()
    }


    private fun initView() {
        userViewModel.init(requireContext())
        arguments?.let {
            firstName = it.getString("firstName")
            lastName = it.getString("lastName")
            profile = it.getString("profile")
            phone = it.getString("phone")
            userID = it.getString("userID")
            Log.d(
                "EditFragment",
                "First Name: $firstName, Last Name: $lastName, Profile: $profile, Phone: $phone"
            )
        }
        b.tietFirstName.setText(firstName)
        b.tietLastName.setText(lastName)
        b.tietPhone.setText(phone)
        b.ivProfile.load(profile)
        userDao = RoomDBHelper.DatabaseClient.getDatabase(requireContext()).userDao()

    }

    private fun viewListener() {
        b.btnCancle.setOnClickListener {
            findNavController().navigateUp()
        }

        b.btnSave.setOnClickListener {


            userViewModel.updateUser(b.tietFirstName.text.toString().trim(), b.tietLastName.text.toString().trim(),
                b.tietPhone.text.toString().trim() , userID?.toInt() ?: 0)

            findNavController().navigateUp()
        }

        b.btnDelete.setOnClickListener {
            userViewModel.deleteUser(userID?.toInt() ?: 0)
            findNavController().navigateUp()
        }

    }
}