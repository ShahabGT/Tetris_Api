package ir.shahabazimi.tetrisapi.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.shahabazimi.tetrisapi.ui.TetrisFragment

@Module
abstract class TetrisFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesTetrisFragmentInjector(): TetrisFragment
}