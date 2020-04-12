package com.shalan.mergeadapterexample.di

import com.shalan.mergeadapterexample.adapters.UsersAdapter
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/12/20.
 */


val adaptersModule = module {
	factory { UsersAdapter() }
}
