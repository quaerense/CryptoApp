package org.quaerense.cryptoapp.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay
import org.quaerense.cryptoapp.data.database.AppDatabase
import org.quaerense.cryptoapp.data.mapper.CoinMapper
import org.quaerense.cryptoapp.data.network.ApiFactory

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    private val coinInfoDao = AppDatabase.getInstance(context).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService

    private val mapper = CoinMapper()

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = COIN_LIMIT)
                val fromSymbols = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fromSymbols)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map {
                    mapper.mapDtoToDbModel(it)
                }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }
            delay(DELAY_MILLIS)
        }
    }

    companion object {

        const val NAME = "RefreshDataWorker"
        private const val COIN_LIMIT = 50
        private const val DELAY_MILLIS = 10000L

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }

}