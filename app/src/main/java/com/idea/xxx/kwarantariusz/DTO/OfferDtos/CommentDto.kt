package com.idea.xxx.kwarantariusz.DTO.OfferDtos

import com.google.gson.annotations.SerializedName

data class CommentDto(
    @SerializedName("description") val description: String? = null,
    @SerializedName("rate") val rate: Int,
    @SerializedName("user") val user: String,
    @SerializedName("create_date_text") val create_date_text: String? = null,
    @SerializedName("create_date") val create_date: String
)
