package serapbercin.com.myapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import serapbercin.com.myapplication.ui.mainfragment.MainFragment

@Module
abstract class FragmentModule {

	@ContributesAndroidInjector
	abstract fun contributeMainFragment(): MainFragment
}