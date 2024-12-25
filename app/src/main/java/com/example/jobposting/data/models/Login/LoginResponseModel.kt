package com.example.jobposting.data.models.Login

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("id_token")
    val idToken: String
)