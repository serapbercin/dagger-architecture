package serapbercin.com.myapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import serapbercin.com.myapplication.ui.main.MainActivity
import serapbercin.com.myapplication.ui.main.MainActivityModule

@Module
abstract class ActivitiesModule {

	@ContributesAndroidInjector(modules = [(MainActivityModule::class)])
	abstract fun bindMainActivity(): MainActivity

}