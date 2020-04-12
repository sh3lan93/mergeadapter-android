package com.shalan.mergeadapterexample.services

import com.shalan.mergeadapterexample.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
class NetworkClient : INetworkClient {

	val client: Retrofit

	init {
		val okClient = OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()
		client = Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.client(okClient)
			.build()
	}

	override fun getClient(): INetworkClient = this

	override fun <APIService> createService(api: Class<APIService>): APIService = client.create(api)
}
