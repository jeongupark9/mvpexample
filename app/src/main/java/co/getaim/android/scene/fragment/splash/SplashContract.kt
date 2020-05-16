package co.getaim.android.scene.fragment.splash

import co.getaim.android.base.MvpPresenter
import co.getaim.android.base.MvpView

interface SplashContract{
    interface Presenter<V : View> : MvpPresenter<V> {

    }
    interface View : MvpView {

        fun changeText(str : String)
    }
}