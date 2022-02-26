package org.quaerense.cryptoapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.quaerense.cryptoapp.R
import org.quaerense.cryptoapp.data.model.CoinPriceInfo

class CoinInfoAdapter :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var onCoinClickListener: OnCoinClickListener? = null

    interface OnCoinClickListener {
        fun onClick(coin: CoinPriceInfo)
    }

    var coins: List<CoinPriceInfo> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)

        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coins[position]
        val symbols = "${coin.fromSymbol} / ${coin.toSymbol}"

        with(holder) {
            Picasso.get().load(coin.getFullImageUrl()).into(ivLogoCoin)
            tvSymbols.text = symbols
            tvPrice.text = coin.price.toString()
            tvLastUpdate.text = coin.getFormattedTime()

            itemView.setOnClickListener {
                onCoinClickListener?.onClick(coin)
            }
        }
    }

    override fun getItemCount() = coins.size

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin: ImageView = itemView.findViewById(R.id.ivLogoCoin)
        val tvSymbols: TextView = itemView.findViewById(R.id.tvSymbols)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvLastUpdate: TextView = itemView.findViewById(R.id.tvLastUpdate)
    }
}