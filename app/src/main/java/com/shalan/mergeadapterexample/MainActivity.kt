package com.shalan.mergeadapterexample

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.MergeAdapter
import com.shalan.mergeadapterexample.adapters.CommitsAdapter
import com.shalan.mergeadapterexample.adapters.ItemListener
import com.shalan.mergeadapterexample.adapters.UsersAdapter
import com.shalan.mergeadapterexample.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), ItemListener {

	private lateinit var binding: ActivityMainBinding
	private val viewModel: MainViewModel by viewModel()
	private val userAdapter: UsersAdapter by inject { parametersOf(this) }
	private val commitsAdapter: CommitsAdapter by inject { parametersOf(this) }
	lateinit var mergeAdapter: MergeAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		binding.lifecycleOwner = this
		lifecycle.addObserver(viewModel)
		mergeAdapter = MergeAdapter(commitsAdapter, userAdapter)
		configureRecycler()
		observingData()
	}

	private fun observingData(){
		viewModel.users_().observe(this, Observer {
			if (it.isNotEmpty())
				userAdapter.submitList(it)
		})
		viewModel.commits_().observe(this, Observer {
			if (it.isNotEmpty())
				commitsAdapter.submitList(it)
		})
		viewModel.errorEmitter_().observe(this, Observer {
			it?.let {
				Toast.makeText(this, it, Toast.LENGTH_LONG).show()
			}
		})
	}

	private fun configureRecycler() {
		binding.rvUsersAndCommits.addItemDecoration(
			DividerItemDecoration(
				this,
				DividerItemDecoration.VERTICAL
			)
		)
		binding.rvUsersAndCommits.adapter = mergeAdapter
	}

	override fun onItemClicked(position: Int) {
		Toast.makeText(this, "you have clicked $position", Toast.LENGTH_LONG).show()
	}
}
