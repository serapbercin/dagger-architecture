package serapbercin.com.myapplication.data.repo

import io.reactivex.Single
import serapbercin.com.myapplication.data.api.GitHubService
import serapbercin.com.myapplication.data.model.EventList
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val gitHubService: GitHubService) : EventRepository {


	override fun getEvents(): Single<List<EventList>> {
		return gitHubService.getEvents().map {
			it.list
		}
	}


}