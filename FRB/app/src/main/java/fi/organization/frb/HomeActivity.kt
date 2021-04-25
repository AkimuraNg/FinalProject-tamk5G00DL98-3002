package fi.organization.frb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fi.organization.frb.Adapter.CocktailBar
import fi.organization.frb.Adapter.MainCategory
import fi.organization.frb.Adapter.SubCategory
import fi.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.activity_homescreen.*

class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()
    var arrCocktailBar = ArrayList<Recipes>()


    var mainCategory = MainCategory()
    var subCategory = SubCategory()
    var cocktailBar = CocktailBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        //create dummy test for the app
        //dummy for main category
        arrMainCategory.add(Recipes(1, dishName = "Beef"))
        arrMainCategory.add(Recipes(2, dishName = "Chicken"))
        arrMainCategory.add(Recipes(3, dishName = "Pork"))
        arrMainCategory.add(Recipes(4, dishName = "Fish"))
        mainCategory.setData(arrMainCategory)


        //dummy for sub category
        arrSubCategory.add(Recipes(1, dishName = "Beef and Mushroom"))
        arrSubCategory.add(Recipes(2, dishName = "Chicken and Potato"))
        arrSubCategory.add(Recipes(3, dishName = "Pork and Cucumber"))
        arrSubCategory.add(Recipes(4, dishName = "Fish and Chips"))
        subCategory.setData(arrSubCategory)

        //dummy for cocktail category
        arrCocktailBar.add(Recipes(1, dishName = "Tequila Sunrise"))
        arrCocktailBar.add(Recipes(2, dishName = "Bourbon"))
        arrCocktailBar.add(Recipes(3, dishName = "First Love"))
        arrCocktailBar.add(Recipes(4, dishName = "Kamikaze"))
        cocktailBar.setData(arrCocktailBar)

        rv_main_category.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_main_category.adapter=mainCategory

        rv_sub_category.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_sub_category.adapter=subCategory

        rv_cocktail_bar.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_cocktail_bar.adapter=cocktailBar
    }
}
