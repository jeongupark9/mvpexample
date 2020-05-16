package co.getaim.android.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V : MvpView>() : MvpPresenter<V> {
    private val TAG = "BasePresenter"
    private lateinit var mCompositeDisposable : CompositeDisposable
    constructor(compositeDisposable: CompositeDisposable) : this(){
        this.mCompositeDisposable = compositeDisposable
    }
    var mMvpView : V? = null

    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    override fun onDetach() {
        mMvpView = null
    }

    override fun setUserAsLoggedOut() {
        TODO("Not yet implemented")
    }

}