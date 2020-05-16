package co.getaim.android.base

interface MvpView {

    fun showLoading()

    fun hideLoading()

    fun onError(message: String?)

    fun showMessage(message: String?)

    fun isNetworkConnected(): Boolean

    fun hideKeyboard()
}