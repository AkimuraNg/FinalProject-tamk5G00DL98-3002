package com.organization.frb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.organization.frb.R
import com.organization.frb.entities.MealsItems
import kotlinx.android.synthetic.main.rv_sub_category.view.*

/**
 * Create an Adapter for sub category for the application
 *
 * This class works as an data holder.
 *
 * Create a var array list of category which is stored to the Recipes file
 *
 * Data is stored as items in this file
 *
 * Adding ClickedListener. Using Glide to show image in API
 */

class SubCategory: RecyclerView.Adapter<SubCategory.RecipeViewHolder>() {

    var listener: SubCategory.OnItemClickListener? = null
    var ctx :Context? = null
    var arrSubCategory = ArrayList<MealsItems>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    fun setData(arrData : List<MealsItems>){
        arrSubCategory = arrData as ArrayList<MealsItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_sub_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    fun setClickListener(listener1: SubCategory.OnItemClickListener){
        listener = listener1
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.itemView.tv_dish_name.text = arrSubCategory[position].strMeal

        Glide.with(ctx!!).load(arrSubCategory[position].strMealThumb).into(holder.itemView.img_dish)

        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrSubCategory[position].idMeal)
        }
    }

    interface OnItemClickListener{
        fun onClicked(id:String)
    }
}