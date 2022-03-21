package org.quaerense.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import org.quaerense.cryptoapp.domain.GetCoinInfoListUseCase
import org.quaerense.cryptoapp.domain.GetCoinInfoUseCase
import org.quaerense.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    loadDataUseCase: LoadDataUseCase,
    getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}