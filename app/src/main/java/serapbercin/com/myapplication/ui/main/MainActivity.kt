package serapbercin.com.myapplication.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import serapbercin.com.myapplication.R
import serapbercin.com.myapplication.ui.mainfragment.MainFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, MainContract.View {


	@Inject
	lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

	@Inject
	lateinit var presenter: MainContract.Presenter

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		presenter.subscribeEvent()
		val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
		val newCurrentFragment = supportFragmentManager.findFragmentByTag("tag")
				?: MainFragment.newInstance("tag")
		transaction.replace(R.id.fragment_content, newCurrentFragment, "tag")
		transaction.commit()
	}

	override fun supportFragmentInjector() = dispatchingAndroidInjector

}
