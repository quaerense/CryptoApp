package org.quaerense.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import org.quaerense.cryptoapp.data.database.AppDatabase
import org.quaerense.cryptoapp.data.mapper.CoinMapper
import org.quaerense.cryptoapp.data.worker.RefreshDataWorker
import org.quaerense.cryptoapp.domain.CoinInfo
import org.quaerense.cryptoapp.domain.CoinRepository

class CoinRepositoryImpl(private val application: Application) : CoinRepository {

    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()

    private val mapper = CoinMapper()

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return Transformations.map(coinInfoDao.getPriceList()) { coinInfoDbModels ->
            coinInfoDbModels.map { dbModel ->
                mapper.mapDbModelToEntity(dbModel)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return Transformations.map(coinInfoDao.getPriceInfoAboutCoin(fromSymbol)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}