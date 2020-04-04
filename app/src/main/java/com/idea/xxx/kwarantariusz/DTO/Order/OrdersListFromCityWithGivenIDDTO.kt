package com.idea.xxx.kwarantariusz.DTO.Order

import com.google.gson.annotations.SerializedName

data class OrdersListFromCityWithGivenIDDTO(@SerializedName("orders") val orders: List<OrderDTO>)