package com.siarheikrupenich.testrepo.entity

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RepoApiEntity(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("description")
    val description: String?
)
