package serapbercin.com.myapplication.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import serapbercin.com.myapplication.SampleApplication
import serapbercin.com.myapplication.data.DataModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
	ActivitiesModule::class,
	FragmentModule::class, DataModule::class])
interface ApplicationComponent {

	fun inject(sampleApplication: SampleApplication)

	@Component.Builder
	interface Builder {

		fun build(): ApplicationComponent

		@BindsInstance
		fun sampleApplicationBind(sampleApplication: SampleApplication): Builder

	}


}