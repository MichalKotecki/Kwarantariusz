package com.idea.xxx.kwarantariusz.DTO.OfferDtos

import com.google.gson.annotations.SerializedName

data class CommentsDto(@SerializedName("comments") val comments: List<CommentDto>? = null)