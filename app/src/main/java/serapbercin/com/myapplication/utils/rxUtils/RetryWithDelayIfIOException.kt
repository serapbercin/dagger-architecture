package serapbercin.com.myapplication.utils.rxUtils


import io.reactivex.Flowable
import io.reactivex.functions.Function
import org.reactivestreams.Publisher
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

private const val RETRY_DELAY_MICROS = 2

class RetryWithDelayIfIOException :
		Function<Flowable<Throwable>, Publisher<*>> {
	override fun apply(attempts: Flowable<Throwable>): Publisher<*> {
		return attempts.flatMap { throwable ->
			return@flatMap getObservable(throwable)
		}
	}


	private fun getObservable(throwable: Throwable): Publisher<*> {
		return when {
			(throwable is UnknownHostException) -> Flowable.timer(RETRY_DELAY_MICROS.toLong(), TimeUnit.MICROSECONDS)
			else -> Flowable.error<Any>(throwable)
		}

	}


}