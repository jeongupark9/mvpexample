package co.getaim.android.base

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import com.example.mvpmodeltest.R
import co.getaim.android.util.ColorUtil
import java.util.ArrayList

abstract class BaseActivity : FragmentActivity() , MvpView{

    var fragmentList: ArrayList<BaseFragment> = ArrayList<BaseFragment>()
    private var doubleBackToExitPressedOnce = false
    private var isBacking = false
    private var statusBarHexColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(
            R.anim.fade_in,
            R.anim.fade_out
        )
    }

    override fun onBackPressed() {
        if (fragmentList.size > 0 && fragmentList.size != 1) {
            if (!fragmentList[fragmentList.size - 1].onBackPressed()) {
                return
            }
            if (isBacking) {
                return
            }
            fragmentList[fragmentList.size - 1].popFragment()
            if (!isBacking) {
                isBacking = true
                Handler().postDelayed({ isBacking = false }, 500)
            }
            return
        }

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true

        Toast.makeText(this, "뒤로가기를 한번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1500)
    }
    fun onReturn() {

    }


    fun popBackStack(isReturn: Boolean, fragment: Fragment, isAnim: Boolean) {
        if ((fragment as BaseFragment).isLoading) {
            return
        }
        if (isReturn) {
            if (fragmentList.size > 1) {
                fragmentList[fragmentList.size - 2].onReturn()
            } else {
                onReturn()
            }
        }
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if (isAnim) {
            transaction.setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        }
        transaction.remove(fragment)
        transaction.commitAllowingStateLoss()
        if (isAnim) {
            if (fragmentList.size > 1) {
                val xmlAnimation = AnimationUtils.loadAnimation(
                    baseContext,
                    R.anim.slide_in_left
                )
                fragmentList[fragmentList.size - 2].getMotherView()?.startAnimation(xmlAnimation)
            }
        }
    }

    fun popFragment(fragment: BaseFragment) {
        popBackStack(fragment, true)
    }
    fun popBackStack(fragment: Fragment, isAnim: Boolean) {
        popBackStack(true, fragment, isAnim)
    }

    fun popBackStackClose(
        fragment: Fragment,
        isAnim: Boolean
    ) {
        if ((fragment as BaseFragment).isLoading) {
            return
        }
        if (fragmentList.size > 1) {
            fragmentList[fragmentList.size - 2].onReturn()
        } else {
            onReturn()
        }
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if (isAnim) transaction.setCustomAnimations(
            R.anim.slide_up_in,
            R.anim.slide_down_out
        )
        transaction.remove(fragment)
        transaction.commitAllowingStateLoss()
    }


    fun pushFragment(fragment: Fragment) {

        if (null != findViewById(R.id.fragment_container)) {
            findViewById<View>(R.id.fragment_container).bringToFront()
        }
        val transaction =
            supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
        transaction.add(R.id.fragment_container, fragment, fragment.javaClass.name)
        transaction.commitAllowingStateLoss()

    }



    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onError(message: String?) {
        TODO("Not yet implemented")
    }

    override fun showMessage(message: String?) {
        TODO("Not yet implemented")
    }

    override fun isNetworkConnected(): Boolean {
        TODO("Not yet implemented")
    }

    override fun hideKeyboard() {
        TODO("Not yet implemented")
    }

}