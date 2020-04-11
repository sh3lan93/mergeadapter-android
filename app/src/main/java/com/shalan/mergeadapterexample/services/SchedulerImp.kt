package com.shalan.mergeadapterexample.services

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler

/**
 * Created by Mohamed Shalan on 4/9/20.
 */
class SchedulerImp : ISchedulers {

	override fun getIOScheduler(): Scheduler = IoScheduler()

	override fun getMainThread(): Scheduler = AndroidSchedulers.mainThread()

}
