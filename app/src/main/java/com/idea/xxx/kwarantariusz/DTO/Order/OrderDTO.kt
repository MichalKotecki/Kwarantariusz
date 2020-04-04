package com.idea.xxx.kwarantariusz.DTO.Order

import com.google.gson.annotations.SerializedName


data class OrderDTO(
    @SerializedName("id_order") val id_order: Long,
    @SerializedName("id_needy") val id_needy: Long,
    @SerializedName("needy_name") val needy_name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("id_quaranteer") val id_quaranteer: Long,

    @SerializedName("quaranteer_name") val quaranteer_name: String,
    @SerializedName("products") val products: List<String>,
    @SerializedName("description") val description: String,
    @SerializedName("max_spend") val max_spend: Long,
    @SerializedName("status") val status: String,

    @SerializedName("address") val address: String
)