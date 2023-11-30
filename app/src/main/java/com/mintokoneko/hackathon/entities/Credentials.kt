package com.mintokoneko.hackathon.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Credentials(
    val login: String,
    val password: String
) : Parcelable
