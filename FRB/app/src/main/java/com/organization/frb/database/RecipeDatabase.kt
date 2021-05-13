package ccom.organization.frb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.organization.frb.dao.RecipeDao
import com.organization.frb.entities.*
import com.organization.frb.entities.converter.CategoryListConverter
import com.organization.frb.entities.converter.MealListConverter
/**
 * Store given data from files to Database
 */

@Database(entities = [Recipes::class,CategoryItems::class,Category::class,Meal::class,MealsItems::class],version = 1,exportSchema = false)
@TypeConverters(CategoryListConverter::class,MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                        context,
                        RecipeDatabase::class.java,
                        "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao():RecipeDao
}