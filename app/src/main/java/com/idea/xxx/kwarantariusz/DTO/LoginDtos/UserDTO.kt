package com.idea.xxx.kwarantariusz.DTO.LoginDtos

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("ID") val ID: Long,
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String,
    @SerializedName("city") val city: String,
    @SerializedName("street") val street: String,
    @SerializedName("name") val name: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("typeUser") val typeUser: String,
    @SerializedName("phoneNumber") val phoneNumber: String
)
