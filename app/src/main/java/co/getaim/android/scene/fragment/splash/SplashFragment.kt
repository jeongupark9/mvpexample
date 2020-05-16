package co.getaim.android.scene.fragment.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import co.getaim.android.base.BaseFragment
import co.getaim.android.base.MvpView
import co.getaim.android.scene.fragment.NextFragment
import com.example.mvpmodeltest.R
import kotlinx.android.synthetic.main.f_splash.*
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment(), SplashContract.View{
    val mPresenter : SplashPresenter<SplashContract.View> by inject()
    override fun getViewResourceID(): Int =
        R.layout.f_splash

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.onAttach(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        f_splash_text_splash.setOnClickListener {
            Log.d("PARK", "TopFragment: ${getTopFragmnet()}")

        }
        f_splash_btn_next.setOnClickListener {
            pushFragment(NextFragment())
        }

        f_splash_btn_change.setOnClickListener {
            mPresenter.mainTextControl()
        }
    }
    override fun onReturn() {
        Log.d("PARK", "onNext onReturn call")
        super.onReturn()

    }

    override fun changeText(str: String) {
        f_splash_text_splash.text = str
    }


}