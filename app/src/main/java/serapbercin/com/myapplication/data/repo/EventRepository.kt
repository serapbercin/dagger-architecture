package serapbercin.com.myapplication.data.repo

import io.reactivex.Single
import serapbercin.com.myapplication.data.model.EventList


interface EventRepository {

	fun getEvents(): Single<List<EventList>>
}