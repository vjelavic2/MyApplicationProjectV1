package hr.ferit.valentina.myapplicationprojectv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.valentina.myapplicationprojectv1.MeniCategoryItem
import hr.ferit.valentina.myapplicationprojectv1.R

class CategoriesAdapter(private val categoryList: List<MeniCategoryItem>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.categoryImage.setImageResource(currentItem.imageCategories)
        holder.categoryName.text = currentItem.nameCategories
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage: ImageView = itemView.findViewById(R.id.categoriesPicture)
        val categoryName: TextView = itemView.findViewById(R.id.categoriesName)
    }
}