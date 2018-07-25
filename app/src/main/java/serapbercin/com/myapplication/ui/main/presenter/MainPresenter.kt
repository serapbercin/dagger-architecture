package serapbercin.com.myapplication.ui.main.presenter

import android.annotation.SuppressLint
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import serapbercin.com.myapplication.data.model.EventList
import serapbercin.com.myapplication.data.repo.EventRepository
import serapbercin.com.myapplication.di.OnDestroy
import serapbercin.com.myapplication.ui.main.MainContract
import serapbercin.com.myapplication.utils.rxUtils.ResponseParser
import serapbercin.com.myapplication.utils.rxUtils.SingleTransformer
import javax.inject.Inject

class MainPresenter @Inject constructor(val view: MainContract.View,
                                        private val repository: EventRepository,
                                        @OnDestroy private val onDestroyCompletable: Completable)
	: MainContract.Presenter {

	@SuppressLint("CheckResult")
	override fun subscribeEvent() {

		repository.getEvents()
				.takeUntil(onDestroyCompletable)
				.observeOn(AndroidSchedulers.mainThread())
				.compose(SingleTransformer(ResponseParser()).resultToResponseWithHttpErrorHandling())
				.subscribe({ eventList ->
					onSuccess(eventList.body()?.list)
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