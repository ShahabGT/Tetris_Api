package ir.shahabazimi.tetrisapi.network

import okhttp3.ConnectionSpec
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    companion object {
        private const val BASE_URL = "https://api.github.com/search/"
    }

    fun <Api> getApi(
            api: Class<Api>
    ): Api {
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 4

        val interceptor = Interceptor { chain: Interceptor.Chain -> chain.proceed(chain.request()) }
        val client = OkHttpClient.Builder().also {
            it.dispatcher(dispatcher)
            it.addInterceptor(interceptor)
            it.connectionSpecs(listOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT))
        }.build()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
    }
}