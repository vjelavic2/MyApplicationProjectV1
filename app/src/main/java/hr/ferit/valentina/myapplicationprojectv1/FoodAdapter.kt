package hr.ferit.valentina.myapplicationprojectv1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.valentina.myapplicationprojectv1.R

class FoodAdapter(private var foodList: List<FoodItem>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun updateData(filteredList: List<FoodItem>) {
        val newList = mutableListOf<FoodItem>()
        newList.addAll(filteredList)
        foodList = newList
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        private val foodName: TextView = itemView.findViewById(R.id.foodName)
        private val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
        private val foodPrice: TextView = itemView.findViewById(R.id.foodPrice)

        fun bind(foodItem: FoodItem) {
            foodImage.setImageResource(foodItem.imageResId)
            foodName.text = foodItem.name
            foodDescription.text = foodItem.description
            foodPrice.text = "$${foodItem.price}"
        }
    }
}