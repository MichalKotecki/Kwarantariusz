package com.idea.xxx.kwarantariusz.DTO.OfferDtos

import com.google.gson.annotations.SerializedName

data class OffersDto(@SerializedName("offers") val offers: List<OfferDto>)