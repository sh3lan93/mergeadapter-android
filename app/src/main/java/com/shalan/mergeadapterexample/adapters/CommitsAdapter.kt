package com.shalan.mergeadapterexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shalan.mergeadapterexample.R
import com.shalan.mergeadapterexample.databinding.CommitItemViewLayoutBinding
import com.shalan.mergeadapterexample.models.Commit

/**
 * Created by Mohamed Shalan on 4/12/20.
 */

class CommitsAdapter : ListAdapter<Commit, CommitsAdapter.CommitViewHolder>(diffUtil) {

	companion object {
		val diffUtil = object : DiffUtil.ItemCallback<Commit>() {
			override fun areItemsTheSame(oldItem: Commit, newItem: Commit): Boolean =
				oldItem == newItem

			override fun areContentsTheSame(oldItem: Commit, newItem: Commit): Boolean =
				oldItem == newItem

		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitViewHolder {
		val binding: CommitItemViewLayoutBinding = DataBindingUtil.inflate(
			LayoutInflater.from(parent.context),
			R.layout.commit_item_view_layout,
			parent,
			false
		)
		return CommitViewHolder(binding)
	}

	override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	inner class CommitViewHolder(private val binding: CommitItemViewLayoutBinding) :
		RecyclerView.ViewHolder(binding.root) {

		fun bind(item: Commit) {
			binding.commit = item
			binding.executePendingBindings()
		}

	}
}
