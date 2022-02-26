package org.quaerense.cryptoapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoDto(
    @SerializedName("TYPE")
    @Expose
    var type: String? = null,

    @SerializedName("MARKET")
    @Expose
    var market: String? = null,

    @SerializedName("FROMSYMBOL")
    @Expose
    var fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    var toSymbol: String? = null,

    @SerializedName("FLAGS")
    @Expose
    var flags: String? = null,

    @SerializedName("PRICE")
    @Expose
    var price: String? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    var lastUpdate: Long? = null,

    @SerializedName("MEDIAN")
    @Expose
    var median: Double? = null,

    @SerializedName("LASTVOLUME")
    @Expose
    var lastVolume: Double? = null,

    @SerializedName("LASTVOLUMETO")
    @Expose
    var lastVolumeTo: Double? = null,

    @SerializedName("LASTTRADEID")
    @Expose
    var lastTradeId: String? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    var volumeDay: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    var volumeDayTo: Double? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    var volume24Hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    var volume24HourTo: Double? = null,

    @SerializedName("OPENDAY")
    @Expose
    var openDay: Double? = null,

    @SerializedName("HIGHDAY")
    @Expose
    var highDay: String? = null,

    @SerializedName("LOWDAY")
    @Expose
    var lowDay: String? = null,

    @SerializedName("OPEN24HOUR")
    @Expose
    var open24Hour: Double? = null,

    @SerializedName("HIGH24HOUR")
    @Expose
    var high24Hour: Double? = null,

    @SerializedName("LOW24HOUR")
    @Expose
    var low24Hour: Double? = null,

    @SerializedName("LASTMARKET")
    @Expose
    var lastMarket: String? = null,

    @SerializedName("VOLUMEHOUR")
    @Expose
    var volumeHour: Double? = null,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    var volumeHourTo: Double? = null,

    @SerializedName("OPENHOUR")
    @Expose
    var openHour: Double? = null,

    @SerializedName("HIGHHOUR")
    @Expose
    var highHour: Double? = null,

    @SerializedName("LOWHOUR")
    @Expose
    var lowHour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    var topTierVolume24Hour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    var topTierVolume24HourTo: Double? = null,

    @SerializedName("CHANGE24HOUR")
    @Expose
    var change24Hour: Double? = null,

    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    var changePct24Hour: Double? = null,

    @SerializedName("CHANGEDAY")
    @Expose
    var changeDay: Double? = null,

    @SerializedName("CHANGEPCTDAY")
    @Expose
    var changePctDay: Double? = null,

    @SerializedName("CHANGEHOUR")
    @Expose
    var changeHour: Double? = null,

    @SerializedName("CHANGEPCTHOUR")
    @Expose
    var changePctHour: Double? = null,

    @SerializedName("CONVERSIONTYPE")
    @Expose
    var conversionType: String? = null,

    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    var conversionSymbol: String? = null,

    @SerializedName("SUPPLY")
    @Expose
    var supply: Int? = null,

    @SerializedName("MKTCAP")
    @Expose
    var mktCap: Double? = null,

    @SerializedName("MKTCAPPENALTY")
    @Expose
    var mktCapPenalty: Int? = null,

    @SerializedName("CIRCULATINGSUPPLY")
    @Expose
    var circulatingSupply: Int? = null,

    @SerializedName("CIRCULATINGSUPPLYMKTCAP")
    @Expose
    var circulatingSupplyMktCap: Double? = null,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    var totalVolume24h: Double? = null,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    var totalVolume24hTo: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    var totalTopTierVolume24h: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    var totalTopTierVolume24hTo: Double? = null,

    @SerializedName("IMAGEURL")
    @Expose
    var imageUrl: String? = null,
)