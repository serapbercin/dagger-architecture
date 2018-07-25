package serapbercin.com.myapplication.data.api

import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import serapbercin.com.myapplication.data.model.EventResponse


interface GitHubService {

	@GET("/events")
	fun getEvents(): Single<Result<EventResponse>>

}