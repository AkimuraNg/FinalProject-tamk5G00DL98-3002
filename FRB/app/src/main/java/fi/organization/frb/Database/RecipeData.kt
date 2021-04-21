package fi.organization.frb.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fi.organization.frb.Dao.RecipeQuery
import fi.organization.frb.entities.Recipies

@Database(entities = [Recipies::class], version = 1, exportSchema = false)
abstract class RecipeData : RoomDatabase(){
    companion object{
        var recipiesDatabase:RecipeData?= null
        @Synchronized
        fun getDatabase(context: Context):RecipeData{
            if(recipiesDatabase != null){
                recipiesDatabase = Room.databaseBuilder(
                    context,
                    RecipeData::class.java,
                    "recipe.db"
                ).build()
            }
            return recipiesDatabase!!
        }
    }
    abstract fun RecipeQuery():RecipeQuery
}