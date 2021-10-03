package covenant.tribal

import android.app.Application
import com.google.firebase.FirebaseApp
import covenant.tribal.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import timber.log.Timber

class Application : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@Application)
            koin.loadModules(listOf(module))
        }
    }
}