package serapbercin.com.myapplication

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import serapbercin.com.myapplication.di.DaggerApplicationComponent
import javax.inject.Inject


class SampleApplication : Application(), HasActivityInjector {

	@Inject
	lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


	override fun onCreate() {
		super.onCreate()

		DaggerApplicationComponent.builder()
				.sampleApplicationBind(this)
				.build()
				.inject(this)
	}

	override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}