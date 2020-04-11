package com.shalan.mergeadapterexample.di

import com.shalan.mergeadapterexample.MainRepo
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/12/20.
 */

val repoModule = module {
	factory { MainRepo(api = get()) }
}
