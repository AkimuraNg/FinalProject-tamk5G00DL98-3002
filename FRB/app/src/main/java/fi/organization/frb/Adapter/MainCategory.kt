package fi.organization.frb.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fi.organization.frb.R
import fi.organization.frb.entities.Recipes
import kotlinx.android.synthetic.main.main_category.view.*

class MainCategory:RecyclerView.Adapter<MainCategory.Holder>() {

    var arrMainCategory = ArrayList<Recipes>()
    class Holder(view: View): RecyclerView.ViewHolder(view){

    }
    fun setData(arrData: List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return MainCategory.Holder(LayoutInflater.from(parent.context).inflate(R.layout.main_category, parent, false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.tv_all_recipes.text = arrMainCategory[position].dishName
    }


}
