package co.getaim.android.base


import co.getaim.android.scene.activity.MainActivityContract
import co.getaim.android.scene.activity.MainActivityPresenter
import co.getaim.android.scene.fragment.splash.SplashContract
import co.getaim.android.scene.fragment.splash.SplashModel
import co.getaim.android.scene.fragment.splash.SplashPresenter
import org.koin.dsl.module

val mvpModule = module {

    single{ SplashModel()}
    factory { MainActivityPresenter<MainActivityContract.View>()}
    factory { SplashPresenter<SplashContract.View>(get()) }
}
