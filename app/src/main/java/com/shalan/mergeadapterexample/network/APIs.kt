package com.shalan.mergeadapterexample.network

import com.shalan.mergeadapterexample.models.Commit
import com.shalan.mergeadapterexample.models.User
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
interface APIs {

	@GET("users")
	fun getUsers(): Single<List<User>>

	@GET("commits")
	fun getCommits(): Single<List<Commit>>
}
