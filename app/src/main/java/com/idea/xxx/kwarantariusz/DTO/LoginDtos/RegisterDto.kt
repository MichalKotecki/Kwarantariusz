package com.idea.xxx.kwarantariusz.DTO.LoginDtos

import com.google.gson.annotations.SerializedName

data class RegisterDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("username") val username: String,
    @SerializedName("typeUser") val typeUser: String
)