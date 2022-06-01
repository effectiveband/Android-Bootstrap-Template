package band.effective.di.modules

import android.app.Application
import android.content.Context
import band.effective.BuildConfig.VERSION_NAME
import band.effective.core.di.InjectedKey
import band.effective.core.di.scope.AppScope
import com.ramcosta.composedestinations.BuildConfig
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
        fun provideAppVersionName(): String = VERSION_NAME
    }
}
