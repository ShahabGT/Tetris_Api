package ir.shahabazimi.tetrisapi.di

import dagger.Module
import dagger.Provides
import ir.shahabazimi.tetrisapi.network.NetworkApi
import ir.shahabazimi.tetrisapi.network.RemoteDataSource
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNetworkApi(remoteDataSource: RemoteDataSource): NetworkApi {
        return remoteDataSource.getApi(NetworkApi::class.java)
    }
}