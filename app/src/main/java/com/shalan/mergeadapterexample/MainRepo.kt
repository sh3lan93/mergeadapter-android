package com.shalan.mergeadapterexample

import com.shalan.mergeadapterexample.network.APIs
import com.shalan.mergeadapterexample.services.ISchedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Mohamed Shalan on 4/9/20.
 */
class MainRepo(private val api: APIs) : KoinComponent {

	private val scheduler: ISchedulers by inject()

	fun getUsers() =
		api.getUsers()
			.subscribeOn(scheduler.getIOScheduler())
			.observeOn(scheduler.getMainThread())

	fun getCommits() =
		api.getCommits()
			.subscribeOn(scheduler.getIOScheduler())
			.observeOn(scheduler.getMainThread())
}
