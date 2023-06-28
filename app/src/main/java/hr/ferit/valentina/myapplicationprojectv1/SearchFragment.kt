package hr.ferit.valentina.myapplicationprojectv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.valentina.myapplicationprojectv1.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: FoodAdapter
    private val foodList = mutableListOf<FoodItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodList.add(FoodItem("Bacon Hamburger", "Bacon, cheese,lettuce,tomatoes", "12.99", R.drawable.pop_2))
        foodList.add(FoodItem("Cheeseburger", "Cheeses, lettuce, tomatoes", "10.99", R.drawable.cheeseburger))
        foodList.add(FoodItem("Pepperoni Pizza", "Pepperoni, cheese, olives ", "8.99", R.drawable.pop_1))
        foodList.add(FoodItem("Vegetable Pizza", "Peppers, onion, tomatoes, mushrooms", "9.99", R.drawable.pop_3))
        foodList.add(FoodItem("Coca Cola", "Fizzy drink", "1.99", R.drawable.cola))


        adapter = FoodAdapter(foodList)
        binding.recyclerFood.adapter = adapter
        binding.recyclerFood.layoutManager = LinearLayoutManager(requireContext())

        binding.searchBtnn.setOnClickListener {
            val searchQuery = binding.insertFood.text.toString()
            val filteredList = foodList.filter { it.name.contains(searchQuery, ignoreCase = true) }
            adapter.updateData(filteredList)
        }
    }
}