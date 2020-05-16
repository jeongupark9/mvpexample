package co.getaim.android.scene.activity

import co.getaim.android.base.MvpPresenter
import co.getaim.android.base.MvpView

interface MainActivityContract{

    interface  View : MvpView{
        fun openMainActivity()
    }

    interface Presenter< V :View > : MvpPresenter<V>{
        fun requestPermission()
    }

}