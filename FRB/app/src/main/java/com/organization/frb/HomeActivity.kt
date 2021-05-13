package com.organization.frb

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ccom.organization.frb.database.RecipeDatabase
import com.organization.frb.adapter.CocktailBar
import com.organization.frb.adapter.MainCategory
import com.organization.frb.adapter.SubCategory
import com.organization.frb.entities.CategoryItems
import com.organization.frb.entities.MealsItems
import com.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

/**
 *Home Activity which will be launch in the home screen of the application.
 *
 * This class contain data for the activities in the home screen.
 *
 * In the home screen of the app there will be three factor: main category, sub category.
 *
 * @paramRecipes is the kotlin file works as an entity for two category and is an array list
 * which helps store data for the application.
 */

class HomeActivity : BaseActivity() {
    /**
     * Make var to store arraylist of items
     * */
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<MealsItems>()
    var arrCocktailBar = ArrayList<Recipes>()

    /**
     * Create var which belongs to the previous var
     * Data is stored in these files.
     */
    var mainCategory = MainCategory()
    var subCategory = SubCategory()
    var cocktailBar = CocktailBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        getDataFromDb()

        mainCategory.setClickListener(onCLicked)
        subCategory.setClickListener(onCLickedSubItem)

        /**
         * Making test dummies for cocktail and add them to the application
         *
         * Making a simple list of four recipes and add them to array Recipes and then stored in the array of each categories
         * Then each var created wil have the data transfer from the given list of array
         */
        arrCocktailBar.add(Recipes(1, dishName = "Tequila Sunrise"))
        arrCocktailBar.add(Recipes(2, dishName = "Bourbon"))
        arrCocktailBar.add(Recipes(3, dishName = "First Love"))
        arrCocktailBar.add(Recipes(4, dishName = "Kamikaze"))
        arrCocktailBar.add(Recipes(5, dishName = "Martini"))
        arrCocktailBar.add(Recipes(6, dishName = "God Father"))
        cocktailBar.setData(arrCocktailBar)

        rv_cocktail_bar.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_cocktail_bar.adapter=cocktailBar
    }

    private val onCLicked  = object : MainCategory.OnItemClickListener{
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }

    private val onCLickedSubItem  = object : SubCategory.OnItemClickListener{
        override fun onClicked(id: String) {
            var intent = Intent(this@HomeActivity,DetailActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }

    /**
     * Create function to get Category data from database and RecipeDao
     * Using coroutineScope
     * Set data to xml files with proper layout and adjustment to fit the screen
     */

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()

                getMealDataFromDb(arrMainCategory[0].strcategory)
                mainCategory.setData(arrMainCategory)
                rv_main_category.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                rv_main_category.adapter = mainCategory
            }


        }
    }

    /**
     * Create function to get Meal data from database and RecipeDao
     * Using coroutineScope
     * Set data to xml files with proper layout and adjustment to fit the screen
     */

    private fun getMealDataFromDb(categoryName:String){
        tvCategory.text = "$categoryName Category"
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                subCategory.setData(arrSubCategory)
                rv_sub_category.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                rv_sub_category.adapter = subCategory
            }


        }
    }
}