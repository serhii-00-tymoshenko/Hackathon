package com.mintokoneko.hackathon.entities

import android.os.Parcelable
import com.mintokoneko.hackathon.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee(
    val name: String,
    val photo: Int = R.drawable.ic_launcher_background,
    val position: String = "Employee",
    val trustLevel: Int = R.color.yellow,
    val id: Int
) : Parcelable
