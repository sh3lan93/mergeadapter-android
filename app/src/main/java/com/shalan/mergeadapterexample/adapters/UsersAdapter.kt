package com.shalan.mergeadapterexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shalan.mergeadapterexample.R
import com.shalan.mergeadapterexample.databinding.UserItemViewLayoutBinding
import com.shalan.mergeadapterexample.models.User

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
class UsersAdapter(private val listener: ItemListener) :
	ListAdapter<User, UsersAdapter.UsersViewHolder>(diffUtil) {

	companion object {
		val diffUtil = object : DiffUtil.ItemCallback<User>() {
			override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

			override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
				oldItem == newItem

		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
		val binding: UserItemViewLayoutBinding = DataBindingUtil.inflate(
			LayoutInflater.from(parent.context),
			R.layout.user_item_view_layout,
			parent,
			false
		)
		return UsersViewHolder(binding, listener)
	}

	override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	inner class UsersViewHolder(
		private val binding: UserItemViewLayoutBinding,
		private val listener: ItemListener
	) :
		RecyclerView.ViewHolder(binding.root) {

		fun bind(item: User) {
			binding.user = item
			binding.executePendingBindings()
			binding.root.setOnClickListener {
				listener.onItemClicked(bindingAdapterPosition)
			}
		}
	}
}
