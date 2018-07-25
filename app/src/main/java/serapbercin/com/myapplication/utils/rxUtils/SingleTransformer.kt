package serapbercin.com.myapplication.utils.rxUtils

import io.reactivex.Single
import io.reactivex.SingleTransformer
import retrofit2.Response
import retrofit2.adapter.rxjava2.Result
import java.io.IOException
import java.net.HttpURLConnection.HTTP_BAD_REQUEST


class SingleTransformer(responseParser: ResponseParser) {

	fun <T> resultToResponseWithHttpErrorHandling(): SingleTransformer<Result<T>, Response<T>> {
		return SingleTransformer { it ->
			it.flatMap { result ->
				var returnObservable: Single<Response<T>> = Single.never()
				returnObservable = getObservable(result, returnObservable)
				returnObservable
			}.retryWhen(RetryWithDelayIfIOException())
		}
	}

	private fun <T> getObservable(result: Result<T>, returnObservable: Single<Response<T>>): Single<Response<T>> {
		return when {
			result.response() == null -> when {
				result.isError -> returnObservableWithInternalException(result)
				else -> Single.never()
			}
			else -> when {
				result.response()!!.code() < HTTP_BAD_REQUEST -> returnSuccessObservable(result)
				else -> returnObservableWithException(result, returnObservable)
			}
		}
	}

	private fun <T> returnObservableWithException(result: Result<T>, returnObservable: Single<Response<T>>): Single<Response<T>> {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
		//TODO response parser
	}

	private fun <T> returnSuccessObservable(result: Result<T>): Single<Response<T>> =
			Single.just(result.response()!!)!!


	private fun <T> returnObservableWithInternalException(r: Result<T>): Single<Response<T>> {
		val returnObservable: Single<Response<T>>
		val throwable = r.error()
		returnObservable = when (throwable) {
			is IOException -> observableThrowable(throwable)
			else -> returnObservableInternalException(throwable)
		}
		return returnObservable
	}


	private fun <T> returnObservableInternalException(throwable: Throwable?): Single<Response<T>> =
			Single.error(throwable)

	private fun <T> observableThrowable(throwable: Throwable): Single<Response<T>> =
			Single.error(throwable)

}







