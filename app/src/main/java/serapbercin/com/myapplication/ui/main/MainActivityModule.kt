package serapbercin.com.myapplication.ui.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Completable
import serapbercin.com.myapplication.di.ActivityScope
import serapbercin.com.myapplication.di.OnDestroy
import serapbercin.com.myapplication.ui.main.presenter.MainPresenter


@Module
abstract class MainActivityModule {

	@Module
	companion object {
		@JvmStatic
		@Provides
		@OnDestroy
		fun provideOnDestroyCompletable(
				activity: MainActivity): Completable = activity.onDestroyCompletable
	}

	@ActivityScope
	@Binds
	abstract fun bindView(mainActivity: MainActivity): MainContract.View

	@ActivityScope
	@Binds
	abstract fun bindPresenter(presenter: MainPresenter): MainContract.Presenter

}