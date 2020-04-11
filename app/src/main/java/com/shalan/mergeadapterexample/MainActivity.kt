package com.shalan.mergeadapterexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shalan.mergeadapterexample.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private val viewModel: MainViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		binding.lifecycleOwner = this
		lifecycle.addObserver(viewModel)
	}
}
