package fi.organization.frb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Recipes")
data class Recipies(
    @PrimaryKey(autoGenerate = true)
    var id:Int
) : Serializable
