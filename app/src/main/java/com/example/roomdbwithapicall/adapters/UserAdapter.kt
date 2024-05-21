package com.example.roomdbwithapicall.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.roomdbwithapicall.databinding.ItemUserListBinding
import com.example.roomdbwithapicall.model.UsersResponse

class UserAdapter() :
    ListAdapter<UsersResponse.User, UserAdapter.UserViewHolder>(UserDiffCallback) {

    inner class UserViewHolder(private val binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*init {
            binding.root.setOnClickListener {
                val movie = getItem(adapterPosition)
            }
        }*/

        fun bind(user: UsersResponse.User) {
            binding.apply {
                tvPhone.text = user.phone
                tvFullName.text = user.firstName.plus(" ").plus(user.lastName)
                ivUser.load(user.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }


    object UserDiffCallback : DiffUtil.ItemCallback<UsersResponse.User>() {
        override fun areItemsTheSame(oldItem: UsersResponse.User, newItem: UsersResponse.User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UsersResponse.User, newItem: UsersResponse.User): Boolean {
            return oldItem == newItem
        }
    }

}