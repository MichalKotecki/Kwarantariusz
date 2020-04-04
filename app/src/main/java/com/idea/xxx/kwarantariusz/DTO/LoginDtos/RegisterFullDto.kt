package com.idea.xxx.kwarantariusz.DTO.LoginDtos

import com.google.gson.annotations.SerializedName

data class RegisterFullDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("username") val username: String,
    @SerializedName("city") val city :String ?= null,
    @SerializedName("street") val street: String,
    @SerializedName("typeUser") val typeUser: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("profilePath") val profilePath: String
) {
}