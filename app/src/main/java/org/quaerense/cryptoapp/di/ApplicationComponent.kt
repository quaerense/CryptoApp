package org.quaerense.cryptoapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import org.quaerense.cryptoapp.presentation.CoinDetailFragment
import org.quaerense.cryptoapp.presentation.CoinPriceListActivity

@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: CoinDetailFragment)

    fun inject(activity: CoinPriceListActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}