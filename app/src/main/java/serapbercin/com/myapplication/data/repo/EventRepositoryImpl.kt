package serapbercin.com.myapplication.data.repo

import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import serapbercin.com.myapplication.data.api.GitHubService
import serapbercin.com.myapplication.data.model.EventResponse
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val gitHubService: GitHubService) : EventRepository {


	override fun getEvents(): Single<Result<EventResponse>> {
		return gitHubService.getEvents().map {
			it
		}
	}


}