package com.organization.frb.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.organization.frb.R
import com.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.cocktail_bar.view.*
/**
 * Create an Adapter for cocktails for the application
 *
 * This class works as an data holder.
 *
 * Create a var array list of category which is stored to the Recipes file
 *
 * Data is stored as items in this file
 */
class CocktailBar:RecyclerView.Adapter<CocktailBar.Holder>() {

    var arrCocktailBar = ArrayList<Recipes>()
    class Holder(view: View): RecyclerView.ViewHolder(view){

    }
    fun setData(arrData: List<Recipes>){
        arrCocktailBar = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.cocktail_bar,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.tv_all_recipes.text = arrCocktailBar[position].dishName
    }

    override fun getItemCount(): Int {
        return arrCocktailBar.size
    }

}