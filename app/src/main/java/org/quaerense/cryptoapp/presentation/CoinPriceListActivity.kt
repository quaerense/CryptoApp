package org.quaerense.cryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.quaerense.cryptoapp.presentation.adapters.CoinInfoAdapter
import org.quaerense.cryptoapp.databinding.ActivityCoinPriceListBinding
import org.quaerense.cryptoapp.data.model.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoinPriceListBinding
    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CoinInfoAdapter()
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onClick(coin: CoinPriceInfo) {
                val intent =
                    CoinDetailActivity.newIntent(this@CoinPriceListActivity, coin.fromSymbol)
                startActivity(intent)
            }
        }

        binding.rvCoinPriceList.adapter = adapter

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(CoinViewModel::class.java)
        viewModel.priceList.observe(this, {
            adapter.coins = it
        })
    }
}