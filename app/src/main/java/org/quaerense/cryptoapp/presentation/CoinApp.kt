package org.quaerense.cryptoapp.presentation

import android.app.Application
import org.quaerense.cryptoapp.di.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}