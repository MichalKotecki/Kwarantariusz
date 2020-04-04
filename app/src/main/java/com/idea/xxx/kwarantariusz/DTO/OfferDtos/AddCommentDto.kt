package com.idea.xxx.kwarantariusz.DTO.OfferDtos

import com.google.gson.annotations.SerializedName
import java.util.*

data class AddCommentDto(
    @SerializedName("description") val description: String? = null,
    @SerializedName("user_id") val user_id: Long,
    @SerializedName("create_date_text") val create_date_text: String ?=null,
    @SerializedName("create_date") val create_date: Date,
    @SerializedName("offer_id") val offer_id: Long,
    @SerializedName("rate") val rate: Int
    )