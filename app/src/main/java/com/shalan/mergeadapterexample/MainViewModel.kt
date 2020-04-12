package com.shalan.mergeadapterexample

import androidx.lifecycle.*
import com.shalan.mergeadapterexample.models.Commit
import com.shalan.mergeadapterexample.models.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.zipWith
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Mohamed Shalan on 4/9/20.
 */
class MainViewModel(private val repo: MainRepo) : ViewModel(), LifecycleObserver, KoinComponent {

	private val disposable: CompositeDisposable by inject()

	private val users: MutableLiveData<List<User>> by lazy {
		MutableLiveData<List<User>>()
	}

	fun users_(): LiveData<List<User>> = users

	private val errorEmitter: MutableLiveData<String?> by lazy {
		MutableLiveData<String?>()
	}

	fun errorEmitter_(): LiveData<String?> = errorEmitter

	private val commits: MutableLiveData<List<Commit>> by lazy {
		MutableLiveData<List<Commit>>()
	}

	fun commits_(): LiveData<List<Commit>> = commits

	@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
	fun fetchUsers() {
		repo.getUsers().zipWith(repo.getCommits()).subscribe({
			users.value = it.first
			commits.value = it.second
		}, {
			errorEmitter.value = it.localizedMessage
		}).addTo(disposable)
	}

	override fun onCleared() {
		disposable.dispose()
		super.onCleared()
	}
}

