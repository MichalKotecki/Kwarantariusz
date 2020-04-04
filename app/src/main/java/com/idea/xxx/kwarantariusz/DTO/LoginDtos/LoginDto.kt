package com.idea.xxx.kwarantariusz.DTO.LoginDtos

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)