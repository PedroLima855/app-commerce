package com.my.appcommerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.appcommerce.adapter.ProductCategoryAdapter
import com.my.appcommerce.model.ProductCategory

class ProductCategoryFragment : Fragment() {

    lateinit var recyclerCategory: RecyclerView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_product_category, container, false)

        recyclerCategory = view.findViewById(R.id.rv_product_category)

        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory(id = "1", title = "Camisetas"),
            ProductCategory(id = "2", title = "Calças"),
            ProductCategory(id = "3", title = "Tenis"),
            ProductCategory(id = "4", title = "Biquinis"),
            ProductCategory(id = "5", title = "Sapatos"),
            ProductCategory(id = "6", title = "Eletrônicos"),
            ProductCategory(id = "7", title = "Músicas"),
            ProductCategory(id = "8", title = "Games"),
            ProductCategory(id = "9", title = "Filmes"),
            ProductCategory(id = "10", title = "Livros")
        )

        val adapterCategory = ProductCategoryAdapter(arrayCategory, requireContext())

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(requireContext(), 2)

        return view;
    }

}