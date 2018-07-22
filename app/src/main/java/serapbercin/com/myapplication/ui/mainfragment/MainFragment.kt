package serapbercin.com.myapplication.ui.mainfragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import serapbercin.com.myapplication.R

class MainFragment : Fragment() {

	override fun onAttach(context: Context?) {
		AndroidSupportInjection.inject(this)
		super.onAttach(context)

	}

	override
	fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                 savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.main_fragment, container, false)
	}

	companion object {
		private const val KEY_SAMPLE: String = "sample"

		@JvmStatic
		fun newInstance(url: String) =
				MainFragment().apply {
					arguments = Bundle().apply {
						putString(KEY_SAMPLE, url)
					}
				}
	}


}