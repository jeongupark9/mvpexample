package co.getaim.android.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.getaim.android.util.PermissionRequestInfo
import io.reactivex.disposables.CompositeDisposable
import java.util.ArrayList

abstract class BaseFragment : Fragment()  , MvpView {
    protected var compositeDisposable = CompositeDisposable()
    private var statusBarHexColor = 0
    private var statusBarResID = 0
    protected var isCloseType: Boolean = false
    protected var myView: View? = null
    var isLoading = false
    protected abstract fun getViewResourceID(): Int
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var viewId: Int = getViewResourceID()
        myView = inflater.inflate(viewId, container, false)
        return myView
    }
    fun onBackPressed(): Boolean {
        return true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (activity is BaseActivity) {
            val fragmentList: ArrayList<BaseFragment> = (activity as BaseActivity).fragmentList
            if (fragmentList.size > 0) {
                val last: BaseFragment = fragmentList[fragmentList.size - 1]
                last.myView?.isClickable = false
            }
            (activity as BaseActivity).fragmentList.add(this)
        }
    }

    fun pushFragment(fragment: Fragment) {
        if (activity is BaseActivity) {
            myView!!.isClickable = false
            (activity as BaseActivity).pushFragment(fragment)
        }
    }


    fun popFragment() {
        if (activity is BaseActivity) {
            if (isCloseType) {
                (activity as BaseActivity).popBackStackClose(this, true)
                return
            }
            (activity as BaseActivity).popFragment(this)
        }
    }


    open fun onReturn() {
        if (null != myView) {
            myView!!.isClickable = true
        }

    }
    fun getTopFragmnet() : BaseFragment?{
        val fragmentlist = (activity as BaseActivity).fragmentList
        if(fragmentlist.size > 0 ){
            return fragmentlist[fragmentlist.size-1]
        }else{
            return null
        }
    }



    fun getMotherView(): View? {
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
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