package com.shalan.mergeadapterexample.di

import com.shalan.mergeadapterexample.network.APIs
import com.shalan.mergeadapterexample.services.INetworkClient
import org.koin.dsl.module

/**
 * Created by Mohamed Shalan on 4/12/20.
 */

val apisModule = module {
	factory { get<INetworkClient>().createService(APIs::class.java) }
}
