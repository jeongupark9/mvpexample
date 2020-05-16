package co.getaim.android.scene.fragment.splash

import co.getaim.android.base.BasePresenter

class SplashPresenter<V : SplashContract.View>(val model: SplashModel): BasePresenter<V>(), SplashContract.Presenter<V>{

    fun mainTextControl(){
        mMvpView!!.changeText( model.modeltestMethod())

    }
}