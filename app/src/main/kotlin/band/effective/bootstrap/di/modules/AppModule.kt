package band.effective.bootstrap.di.modules

import android.app.Application
import android.content.Context
import band.effective.bootstrap.BuildConfig
import band.effective.bootstrap.core.di.InjectedKey
import band.effective.bootstrap.core.di.scope.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
interface AppModule {

    companion object {

        @AppScope
        @Provides
        fun provideContext(app: Application): Context = app.applicationContext

        @JvmStatic
        @Provides
        @Named(InjectedKey.Configuration.VERSION_NAME)
        fun provideAppVersionName(): String = BuildConfig.VERSION_NAME
    }
}
