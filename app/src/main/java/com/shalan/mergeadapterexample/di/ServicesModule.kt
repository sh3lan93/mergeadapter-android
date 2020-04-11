package com.shalan.mergeadapterexample.di

import com.shalan.mergeadapterexample.services.INetworkClient
import com.shalan.mergeadapterexample.services.ISchedulers
import com.shalan.mergeadapterexample.services.NetworkClient
import com.shalan.mergeadapterexample.services.SchedulerImp
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/9/20.
 */

val serviceModule = module {
	single { SchedulerImp() as ISchedulers }
	single { NetworkClient() as INetworkClient }
	single { CompositeDisposable() }
}
