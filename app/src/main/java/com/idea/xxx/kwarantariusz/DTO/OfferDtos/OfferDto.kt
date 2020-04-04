package com.idea.xxx.kwarantariusz.DTO.OfferDtos

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class OfferDto(
    @SerializedName("id") val ID: Long,
    @SerializedName("nameOffer") val nameOffer: String? = null,
    @SerializedName("longitude") val longitude: BigDecimal ?=null,
    @SerializedName("latitude") val latitude: BigDecimal?= null,
    @SerializedName("seller") val seller: Long,
    @SerializedName("description") val description: String,
    @SerializedName("level") val level: String,
    @SerializedName("price_per_hour") val price_per_hour: Long,
    @SerializedName("rate") val rate: String ?=null
)
