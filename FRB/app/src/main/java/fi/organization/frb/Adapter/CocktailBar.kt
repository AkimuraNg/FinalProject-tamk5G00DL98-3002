package fi.organization.frb.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fi.organization.frb.Database.RecipeData
import fi.organization.frb.R
import fi.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.activity_homescreen.view.*
import kotlinx.android.synthetic.main.cocktail_bar.view.*

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
