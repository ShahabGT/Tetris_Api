package ir.shahabazimi.tetrisapi.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import ir.shahabazimi.tetrisapi.misc.MyApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        TetrisFragmentModule::class,
        AppModule::class

    ]
)
interface AppComponent {
    fun inject(application: MyApplication)
}