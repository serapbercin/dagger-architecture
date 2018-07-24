package serapbercin.com.myapplication.ui.main.presenter

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import serapbercin.com.myapplication.data.model.EventList
import serapbercin.com.myapplication.data.repo.EventRepository
import serapbercin.com.myapplication.ui.main.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor(val view: MainContract.View,
                                        private val repository: EventRepository)
	: MainContract.Presenter {

	@SuppressLint("CheckResult")
	override fun subscribeEvent() {

		repository.getEvents()
				.observeOn(AndroidSchedulers.mainThread())
				//TODO Add compose and lifecycle
				.subscribe({ eventList ->
					onSuccess(eventList)
				}, { throwable -> onFailure(throwable) })

	}

	private fun onFailure(throwable: Throwable?) {
		throwable?.let {

		}
	}

	private fun onSuccess(eventList: List<EventList>?) {
		eventList?.let {

		}
	}


}