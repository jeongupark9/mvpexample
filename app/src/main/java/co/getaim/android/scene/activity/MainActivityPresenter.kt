package co.getaim.android.scene.activity

import co.getaim.android.base.BasePresenter

class MainActivityPresenter<V : MainActivityContract.View> : BasePresenter<V>, MainActivityContract.Presenter<V> {
    constructor() : super()
    override fun requestPermission() {
            mMvpView!!.openMainActivity()
    }
}