package fi.organization.frb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import fi.organization.frb.Adapter.MainCategory
import fi.organization.frb.Adapter.SubCategory
import fi.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.activity_homescreen.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategory = MainCategory()
    var subCategory = SubCategory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        //create dummy test for the app
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

        rv_main_category.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_main_category.adapter=mainCategory

        rv_sub_category.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_sub_category.adapter=subCategory
    }
}
