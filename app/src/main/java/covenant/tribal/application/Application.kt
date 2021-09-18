package covenant.tribal.application

import android.app.Application
import covenant.tribal.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import timber.log.Timber

class Application : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@Application)
            koin.loadModules(listOf(module))
        }
    }
}