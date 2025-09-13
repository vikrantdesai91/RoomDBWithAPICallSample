package com.example.roomdbwithapicall.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdbwithapicall.R
import com.example.roomdbwithapicall.adapters.UserAdapter
import com.example.roomdbwithapicall.databinding.FragmentUserListBinding
import com.example.roomdbwithapicall.local.RoomDBHelper
import com.example.roomdbwithapicall.model.UsersModel
import com.example.roomdbwithapicall.viewmodels.UserViewModel
import com.example.sample.local.UserDao

class UserListFragment : Fragment(), UserAdapter.UserCallback {

    private var _binding: FragmentUserListBinding? = null
    private val b get() = _binding!!
    private var userDao: UserDao? = null

    private var userAdapter: UserAdapter? = null
    private val userListViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userListViewModel.init(requireContext())
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userDao = RoomDBHelper.DatabaseClient.getDatabase(requireContext()).userDao()

        initView()
        viewListener()
        getViewModel()
    }

    private fun viewListener() {
        b.btnAdd.setOnClickListener {
            b.tietSearch.setText("")
            findNavController().navigate(R.id.action_userListFragment_to_userAddFragment)
        }
    }

    private fun initView() {

        requireContext().let {
            userAdapter = UserAdapter(arrayListOf(), this)
            b.rvList.apply {
                adapter = userAdapter
            }
        }

    }

    private fun getViewModel() {

        userListViewModel.getUserListRequest()?.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty()) {
                b.tvNoDataMessage.visibility = View.VISIBLE
                userListViewModel.setUserListRequest()
            } else {
                b.tvNoDataMessage.visibility = View.GONE
                userAdapter?.updateList(it)

            }
        }

        userListViewModel.getUserListRequest()?.observe(viewLifecycleOwner) {
            b.tvNoDataMessage.visibility = View.GONE
            userAdapter?.updateList(it ?: emptyList())
            b.tietSearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?, start: Int, count: Int, after: Int
                ) {

                }

                override fun onTextChanged(
                    s: CharSequence?, start: Int, before: Int, count: Int
                ) {
                    val userListFiltered = ArrayList<UsersModel.User>()
                    it?.forEach { user ->
                        val text = user.firstName.plus(user.lastName)
                        if (text.lowercase().contains(s.toString().lowercase())) {
                            userListFiltered.add(user)
                            userAdapter?.updateList(userListFiltered)
                        } else if (text.isEmpty()) {
                            userListFiltered.add(user)
                            userAdapter?.updateList(userListFiltered)
                        } else if (!text.lowercase().contains(s.toString(), true)) {
                            userListFiltered.remove(user)
                            userAdapter?.updateList(userListFiltered)
                        }
                    }
                }

                override fun afterTextChanged(s: Editable?) {

                }

            })
        }

    }

    override fun onUserEdit(users: UsersModel.User?) {

        val bundle = Bundle()
        bundle.apply {
            putString("firstName", users?.firstName)
            putString("lastName", users?.lastName)
            putString("profile", users?.image)
            putString("phone", users?.phone)
            putString("email", users?.email)
            putString("userID", users?.id.toString())
        }
        b.tietSearch.setText("")
        findNavController().navigate(R.id.action_userListFragment_to_userEditFragment, bundle)
    }
}