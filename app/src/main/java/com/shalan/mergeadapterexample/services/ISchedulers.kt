package com.shalan.mergeadapterexample.services

import io.reactivex.Scheduler

/**
 * Created by Mohamed Shalan on 4/9/20.
 */
interface ISchedulers {

	fun getIOScheduler(): Scheduler

	fun getMainThread(): Scheduler
}
