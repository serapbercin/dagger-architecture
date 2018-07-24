package serapbercin.com.myapplication.data.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ApiModule {


	private const val API_URL = "https://api.github.com/"

	@Singleton
	@Provides
	@JvmStatic
	fun provideRetrofit(): Retrofit {

		val interceptor = HttpLoggingInterceptor()
		interceptor.level = HttpLoggingInterceptor.Level.BODY
		val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

		val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create()
		val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

		return Retrofit.Builder()
				.baseUrl(API_URL)
				.client(client)
				.addConverterFactory(GsonConverterFactory.create(gson))
				//.addCallAdapterFactory(CoroutineCallAdapterFactory())
				.addCallAdapterFactory(rxJava2CallAdapterFactory)
				.build()

	}

	@Singleton
	@Provides
	@JvmStatic
	fun provideReviewService(retrofit: Retrofit): GitHubService =
			retrofit.create<GitHubService>(GitHubService::class.java)


}