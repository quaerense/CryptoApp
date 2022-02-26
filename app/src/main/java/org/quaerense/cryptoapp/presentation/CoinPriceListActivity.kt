package org.quaerense.cryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.quaerense.cryptoapp.R
import org.quaerense.cryptoapp.databinding.ActivityCoinPriceListBinding
import org.quaerense.cryptoapp.domain.CoinInfo
import org.quaerense.cryptoapp.presentation.adapters.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel

    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CoinInfoAdapter()
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onClick(coin: CoinInfo) {
                if (isOnePaneMode()) {
                    launchDetailActivity(coin.fromSymbol)
                } else {
                    launchDetailFragment(coin.fromSymbol)
                }
            }
        }

        binding.rvCoinPriceList.adapter = adapter
        binding.rvCoinPriceList.itemAnimator = null

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun isOnePaneMode(): Boolean {
        return binding.fragmentContainer == null
    }

    private fun launchDetailActivity(fromSymbol: String) {
        val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity, fromSymbol)
        startActivity(intent)
    }

    private fun launchDetailFragment(fromSymbol: String) {
        supportFragmentManager.popBackStack()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
            .addToBackStack(null)
            .commit()
    }
}