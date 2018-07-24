package serapbercin.com.myapplication.ui.main

import dagger.Binds
import dagger.Module
import serapbercin.com.myapplication.ui.main.presenter.MainPresenter


@Module
abstract class MainActivityModule {

	@Binds
	abstract fun bindView(mainActivity: MainActivity): MainContract.View

	@Binds
	abstract fun bindPresenter(presenter: MainPresenter): MainContract.Presenter

}