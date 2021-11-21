package com.example.yogagu

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guide")
class Guide {
    @kotlin.jvm.JvmField
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @kotlin.jvm.JvmField
    @ColumnInfo(name = "name")
    var name: String? = null

    @kotlin.jvm.JvmField
    @ColumnInfo(name = "content")
    var content: String? = null

    @kotlin.jvm.JvmField
    @ColumnInfo(name = "visible")
    var visible: String? = null
}