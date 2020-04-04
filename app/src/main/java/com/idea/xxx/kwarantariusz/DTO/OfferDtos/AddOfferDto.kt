package com.idea.xxx.kwarantariusz.DTO.OfferDtos

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class AddOfferDto(
    @SerializedName("seller_id") val seller_id: Long,
    @SerializedName("subject") val subject: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("level") val level: String,
    @SerializedName("nameOffer") val nameOffer: String? = null,
    @SerializedName("longitude") val longitude: BigDecimal? = null,
    @SerializedName("latidute") val latitude: BigDecimal? = null,
    @SerializedName("price_per_hour") val price_per_hour: Long
)