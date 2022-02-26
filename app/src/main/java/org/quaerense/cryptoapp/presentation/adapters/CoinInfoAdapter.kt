package org.quaerense.cryptoapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import org.quaerense.cryptoapp.databinding.ItemCoinInfoBinding
import org.quaerense.cryptoapp.domain.CoinInfo

class CoinInfoAdapter : ListAdapter<CoinInfo, CoinInfoViewHolder>(CoinInfoDiffCallback) {

    var onCoinClickListener: OnCoinClickListener? = null

    interface OnCoinClickListener {
        fun onClick(coin: CoinInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        val symbols = "${coin.fromSymbol} / ${coin.toSymbol}"

        with(holder.binding) {
            with(coin) {
                Picasso.get().load(imageUrl).into(ivLogoCoin)
                tvSymbols.text = symbols
                tvPrice.text = price.toString()
                tvLastUpdate.text = lastUpdate

                root.setOnClickListener {
                    onCoinClickListener?.onClick(this)
                }
            }
        }
    }
}