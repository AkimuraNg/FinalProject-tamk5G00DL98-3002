package com.organization.frb.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * File contain API of category from website
 * API is converted and format using extension DTO from Json and Gson to make data
 */

@Entity(tableName = "CategoryItems")
data class CategoryItems(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "idcategory")
    @Expose
    @SerializedName("idCategory")
    val idcategory: String,

    @ColumnInfo(name = "strcategory")
    @Expose
    @SerializedName("strCategory")
    val strcategory: String,

    @ColumnInfo(name = "strcategorythumb")
    @Expose
    @SerializedName("strCategoryThumb")
    val strcategorythumb: String,

    @ColumnInfo(name = "strcategorydescription")
    @Expose
    @SerializedName("strCategoryDescription")
    val strcategorydescription: String
)

