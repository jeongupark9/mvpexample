package co.getaim.android.scene.activity

import android.os.Bundle
import co.getaim.android.base.BaseActivity
import co.getaim.android.scene.fragment.splash.SplashFragment
import com.example.mvpmodeltest.R
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() , MainActivityContract.View {
    private val mPresenter : MainActivityPresenter<MainActivityContract.View> by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.onAttach(this)
        mPresenter.requestPermission()
    }

    override fun openMainActivity() {
        pushFragment(SplashFragment())
    }

}
