package ir.shahabazimi.tetrisapi.misc

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ir.shahabazimi.tetrisapi.di.AppModule
import ir.shahabazimi.tetrisapi.di.DaggerAppComponent
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}