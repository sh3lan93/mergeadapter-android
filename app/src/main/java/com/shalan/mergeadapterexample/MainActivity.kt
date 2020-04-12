package com.shalan.mergeadapterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.shalan.mergeadapterexample.adapters.UsersAdapter
import com.shalan.mergeadapterexample.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private val viewModel: MainViewModel by viewModel()
	private val userAdapter: UsersAdapter by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		binding.lifecycleOwner = this
		lifecycle.addObserver(viewModel)

		binding.rvUsersAndCommits.adapter = userAdapter
		viewModel.users_().observe(this, Observer {
			if (it.isNotEmpty())
				userAdapter.submitList(it)
		})
	}
}
