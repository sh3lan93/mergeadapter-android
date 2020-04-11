package com.shalan.mergeadapterexample.services

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
interface INetworkClient {

	fun getClient(): INetworkClient

	fun <APIService> createService(api: Class<APIService>): APIService
}
