package com.organization.frb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import ccom.organization.frb.database.RecipeDatabase
import ccom.organization.frb.retofitclient.RetrofitClientInstance
import com.organization.frb.entities.Category
import com.organization.frb.entities.Meal
import com.organization.frb.entities.MealsItems
import com.organization.frb.interfaces.GetDataService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * This is the Main Activity of this application
 *
 * This activity includes button function and connects to Home Activity
 *
 * When clicking the button, Toast message will be executed and users
 * will be directed to the home screen of the app
 */

class MainActivity : BaseActivity(), EasyPermissions.RationaleCallbacks,
    EasyPermissions.PermissionCallbacks {
    private var READ_STORAGE_PERM = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readStorage()
        /**
         * Set button on the log in screen
         * When clicking will print out the given text line
         */
        btnWelcome.setOnClickListener {
            Toast.makeText(this, "Welcome to Food Recipe Book, Let's get started", Toast.LENGTH_LONG).show()
            /**
             * Connect to Home Activity
             */
            var intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /**
     * Make function getCategory to get data from database through retrofit client and data service
     *
     * Using call to get list of categories
     *
     * If failure occur, function onFailure will executed and will print the text
     */

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<Category> {
            override fun onFailure(call: Call<Category>, t: Throwable) {

                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<Category>,
                response: Response<Category>
            ) {

                for (arr in response.body()!!.categorieitems!!) {
                    getMeal(arr.strcategory)
                }
                insertDataIntoRoomDb(response.body())
            }

        })
    }

    /**
     * Make function getMeal to get data from database through retrofit client and data service
     *
     * Using call to get list of categories
     *
     * If failure occur, function onFailure will executed and will print the text
     */

    fun getMeal(categoryName: String) {
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
        val call = service.getMealList(categoryName)
        call.enqueue(object : Callback<Meal> {
            override fun onFailure(call: Call<Meal>, t: Throwable) {

                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<Meal>,
                response: Response<Meal>
            ) {

                insertMealDataIntoRoomDb(categoryName, response.body())
            }

        })
    }

    /**
     * Make function to insert Category data to room database
     */

    fun insertDataIntoRoomDb(category: Category?) {

        launch {
            this.let {

                for (arr in category!!.categorieitems!!) {
                    RecipeDatabase.getDatabase(this@MainActivity)
                        .recipeDao().insertCategory(arr)
                }
            }
        }


    }

    /**
     * Make function to insert Meal data to room database
     */

    fun insertMealDataIntoRoomDb(categoryName: String, meal: Meal?) {

        launch {
            this.let {


                for (arr in meal!!.mealsItem!!) {
                    var mealItemModel = MealsItems(
                        arr.id,
                        arr.idMeal,
                        categoryName,
                        arr.strMeal,
                        arr.strMealThumb
                    )
                    RecipeDatabase.getDatabase(this@MainActivity)
                        .recipeDao().insertMeal(mealItemModel)
                    Log.d("mealData", arr.toString())
                }

                btnWelcome.visibility = View.VISIBLE
            }
        }


    }

    /**
     * Make function to clear Database
     */

    fun clearDataBase() {
        launch {
            this.let {
                RecipeDatabase.getDatabase(this@MainActivity).recipeDao().clearDb()
            }
        }
    }

    /**
     * Make permission function
     *
     * This function will asked users for permissions to access to phone storage like other apps
     *
     * If users denied, the app will shutdown
     */

    private fun hasReadStorage(): Boolean {
        return EasyPermissions.hasPermissions(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    private fun readStorage() {
        if (hasReadStorage()) {
            clearDataBase()
            getCategories()
        } else {
            EasyPermissions.requestPermissions(
                this,
                "This app needs permission to access to phone storage,",
                READ_STORAGE_PERM,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onRationaleDenied(requestCode: Int) {

    }

    override fun onRationaleAccepted(requestCode: Int) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }
}