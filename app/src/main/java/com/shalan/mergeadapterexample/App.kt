package com.shalan.mergeadapterexample

import android.app.Application
import com.shalan.mergeadapterexample.di.apisModule
import com.shalan.mergeadapterexample.di.repoModule
import com.shalan.mergeadapterexample.di.serviceModule
import com.shalan.mergeadapterexample.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Mohamed Shalan on 4/9/20.
 */
class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger()
			androidContext(this@App)
			modules(listOf(serviceModule, apisModule, repoModule, viewModelsModule))
		}
	}
}
