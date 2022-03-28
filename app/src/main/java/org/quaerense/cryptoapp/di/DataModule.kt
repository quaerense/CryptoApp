package org.quaerense.cryptoapp.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import org.quaerense.cryptoapp.data.database.AppDatabase
import org.quaerense.cryptoapp.data.database.CoinInfoDao
import org.quaerense.cryptoapp.data.network.ApiFactory
import org.quaerense.cryptoapp.data.network.ApiService
import org.quaerense.cryptoapp.data.repository.CoinRepositoryImpl
import org.quaerense.cryptoapp.domain.CoinRepository

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }
    }
}