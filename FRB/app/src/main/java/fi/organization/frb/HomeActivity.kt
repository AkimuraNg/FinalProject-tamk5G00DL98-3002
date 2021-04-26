package fi.organization.frb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fi.organization.frb.Adapter.CocktailBar
import fi.organization.frb.Adapter.MainCategory
import fi.organization.frb.Adapter.SubCategory
import fi.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.activity_homescreen.*
/**
 *Home Activity which will be launch in the home screen of the application.
 *
 * This class contain data for the activities in the home screen.
 *
 * In the home screen of the app there will be three factor: main category, sub category and cocktails.
 *
 * @param Recipes is the kotlin file works as an entity for three category and is an array list
 * which helps store data for the application.
 */
class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()
    var arrCocktailBar = ArrayList<Recipes>()

    /**
     * Create var which belongs to the files
     * Data is stored in these files.
     */
    var mainCategory = MainCategory()
    var subCategory = SubCategory()
    var cocktailBar = CocktailBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        /**
         * Making test dummies and add them to the application
         *
         * Making a simple list of four recipes and add them to array Recipes and then stored in the array of each categories
         * Then each var created wil have the data transfered from the given list of array
         */
        arrMainCategory.add(Recipes(1, dishName = "Beef"))
        arrMainCategory.add(Recipes(2, dishName = "Chicken"))
        arrMainCategory.add(Recipes(3, dishName = "Pork"))
        arrMainCategory.add(Recipes(4, dishName = "Fish"))
        mainCategory.setData(arrMainCategory)

        arrSubCategory.add(Recipes(1, dishName = "Beef and Mushroom"))
        arrSubCategory.add(Recipes(2, dishName = "Chicken and Potato"))
        arrSubCategory.add(Recipes(3, dishName = "Pork and Cucumber"))
        arrSubCategory.add(Recipes(4, dishName = "Fish and Chips"))
        subCategory.setData(arrSubCategory)

        arrCocktailBar.add(Recipes(1, dishName = "Tequila Sunrise"))
        arrCocktailBar.add(Recipes(2, dishName = "Bourbon"))
        arrCocktailBar.add(Recipes(3, dishName = "First Love"))
        arrCocktailBar.add(Recipes(4, dishName = "Kamikaze"))
        cocktailBar.setData(arrCocktailBar)

        /**
         * Set the data to the xml files with proper layout
         * Positioning the data to fit to the given screen mearsurement
         */

        rv_main_category.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_main_category.adapter=mainCategory

        rv_sub_category.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_sub_category.adapter=subCategory

        rv_cocktail_bar.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_cocktail_bar.adapter=cocktailBar
    }
}
