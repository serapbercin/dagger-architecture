package serapbercin.com.myapplication.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import serapbercin.com.myapplication.SampleApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
	ActivitiesModule::class,
	FragmentModule::class])
interface ApplicationComponent {

	fun inject(sampleApplication: SampleApplication)

	@Component.Builder
	interface Builder {

		fun build(): ApplicationComponent

		@BindsInstance
		fun sampleApplicationBind(sampleApplication: SampleApplication): Builder

	}


}