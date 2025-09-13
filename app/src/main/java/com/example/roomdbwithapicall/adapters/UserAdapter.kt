package com.example.roomdbwithapicall.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.roomdbwithapicall.databinding.ItemUserListBinding
import com.example.roomdbwithapicall.databinding.ItemViewBinding
import com.example.roomdbwithapicall.model.UsersModel

class UserAdapter(
    private var usersList: List<UsersModel.User>?,
    private var userCallback: UserCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private class UserViewHolder(inflate: ItemViewBinding) :
        RecyclerView.ViewHolder(inflate.root) {
        val b: ItemViewBinding = inflate
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            usersList?.get(position)?.let {user ->
                holder.b.tvEmail.text = user.email
                holder.b.tvPhone.text = user.phone
                holder.b.tvFullname.text = user.firstName.plus(" ").plus(user.lastName)
                holder.b.ivProfile.load(user.image)

                holder.b.root.setOnClickListener {
                    userCallback.onUserEdit(user)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return usersList?.size ?: 0
    }

    fun updateList(userList: List<UsersModel.User>?) {
        this.usersList = userList
        notifyDataSetChanged()
    }

    interface UserCallback {
        fun onUserEdit(users: UsersModel.User?)
    }

}