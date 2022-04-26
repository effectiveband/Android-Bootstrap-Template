package band.effective.bootstrap.network.di

import band.effective.bootstrap.core.di.InjectedKey
import band.effective.bootstrap.core.di.scope.AppScope
import band.effective.bootstrap.network.BuildConfig
import band.effective.bootstrap.network.EitherNewsAdapterFactory
import band.effective.bootstrap.network.interceptors.NewsApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named

@Module
internal interface NewsNetworkModule {

    companion object {

        @Provides
        @Named(InjectedKey.News.BASE_URL)
        fun provideNewsBaseUrl(): String = BuildConfig.NEWS_BASE_URL

        @Provides
        @Named(InjectedKey.News.API_KEY)
        fun provideNewsApiKey(): String = BuildConfig.NEWS_API_KEY

        @NewsNetwork
        @Provides
        @IntoSet
        fun provideNewsApiKeyInterceptor(
            @Named(InjectedKey.News.API_KEY) apiKey: String
        ): Interceptor = NewsApiKeyInterceptor(apiKey)

        @NewsNetwork
        @Provides
        @AppScope
        fun provideNewsClient(
            @BaseNetwork client: OkHttpClient,
            @NewsNetwork interceptors: Set<@JvmSuppressWildcards Interceptor>
        ): OkHttpClient {
            return client.newBuilder()
                .apply { interceptors.forEach(::addInterceptor) }
                .build()
        }

        @NewsNetwork
        @Provides
        @AppScope
        fun provideNewsRetrofit(
            @BaseNetwork retrofit: Retrofit,
            @NewsNetwork newsClient: OkHttpClient,
            @Named(InjectedKey.News.BASE_URL) newsBaseUrl: String
        ): Retrofit {
            return retrofit.newBuilder()
                .baseUrl(newsBaseUrl)
                .client(newsClient)
                .addCallAdapterFactory(EitherNewsAdapterFactory())
                .build()
        }
    }
}
