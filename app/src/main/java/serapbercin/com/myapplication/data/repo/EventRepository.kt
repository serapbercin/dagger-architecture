package serapbercin.com.myapplication.data.repo

import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import serapbercin.com.myapplication.data.model.EventResponse


interface EventRepository {

	fun getEvents(): Single<Result<EventResponse>>
}