package co.getaim.android.base

interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()

//    fun handleApiError(error: ANError?)

    fun setUserAsLoggedOut()

}