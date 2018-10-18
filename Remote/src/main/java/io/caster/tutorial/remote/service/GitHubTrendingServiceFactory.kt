package io.caster.tutorial.remote.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

class GitHubTrendingServiceFactory {

    fun makeGitHubTrendingService(isDebug: Boolean): GitHubTrendingService {
        val okHttpClient = makeOkHttpClient(makeLoggingInterceptor(isDebug))
        return makeGitHubTrendingService(okHttpClient)
    }

    private fun makeGitHubTrendingService(okHttpClient: OkHttpClient): GitHubTrendingService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(GitHubTrendingService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

}