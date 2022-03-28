package org.quaerense.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import org.quaerense.cryptoapp.data.worker.RefreshDataWorkerFactory
import org.quaerense.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApplication : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    @Inject
    lateinit var refreshDataWorkerFactory: RefreshDataWorkerFactory

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(refreshDataWorkerFactory).build()
    }
}