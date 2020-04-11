package com.shalan.mergeadapterexample.di

import com.shalan.mergeadapterexample.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/12/20.
 */

val viewModelsModule = module {
	viewModel { MainViewModel(repo = get()) }
}
