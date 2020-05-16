package co.getaim.android.base

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application(){
    companion object{
        lateinit var appContext : Context
        const val  TAG = "Test"
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this

        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(mvpModule)
        }
    }

}