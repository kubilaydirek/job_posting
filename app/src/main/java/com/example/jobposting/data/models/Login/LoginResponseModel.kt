package com.example.jobposting.data.models.Login

import androidx.compose.runtime.compositionLocalOf
import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("id_token")
    val idToken: String,
    val email : String? = null,
    val firstName : String? = null,
    val lastName : String? = null,
    val imageUrl : String? = null,
)
