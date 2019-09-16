package com.shera.internexttv.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class CustomDirectory(
        @PrimaryKey
        val path: String
)

