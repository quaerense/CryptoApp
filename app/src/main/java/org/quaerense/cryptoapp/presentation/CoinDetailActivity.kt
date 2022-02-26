package org.quaerense.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import org.quaerense.cryptoapp.databinding.ActivityCoinDetailBinding

class CoinDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoinDetailBinding
    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(CoinViewModel::class.java)

        if (fromSymbol != null) {
            viewModel.getDetailInfo(fromSymbol).observe(this) {
                with(binding) {
                    tvFromSymbol.text = it.fromSymbol
                    tvToSymbol.text = it.toSymbol
                    tvPrice.text = it.price.toString()
                    tvMinPrice.text = it.low24Hour.toString()
                    tvMaxPrice.text = it.high24Hour.toString()
                    tvLastMarket.text = it.lastMarket
                    tvLastUpdate.text = it.getFormattedTime()
                    Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
                }
            }
        }
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}