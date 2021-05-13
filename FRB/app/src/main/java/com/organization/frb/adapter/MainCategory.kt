package com.organization.frb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.organization.frb.R
import com.organization.frb.entities.CategoryItems
import kotlinx.android.synthetic.main.rv_main_category.view.*

/**
 * Create an Adapter for main category for the application
 *
 * This class works as an data holder.
 *
 * Create a var array list of category which is stored to the Recipes file
 *
 * Data is stored as items in this file
 *
 * Adding ClickedListener. Using Glide to show image in API
 */

class MainCategory: RecyclerView.Adapter<MainCategory.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var ctx: Context? = null
    var arrMainCategory = ArrayList<CategoryItems>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    fun setData(arrData : List<CategoryItems>){
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_main_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.itemView.tv_dish_name.text = arrMainCategory[position].strcategory
        Glide.with(ctx!!).load(arrMainCategory[position].strcategorythumb).into(holder.itemView.img_dish)
        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrMainCategory[position].strcategory)
        }
    }

    interface OnItemClickListener{
        fun onClicked(categoryName:String)
    }
}