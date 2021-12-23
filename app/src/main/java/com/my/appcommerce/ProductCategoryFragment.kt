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
            ProductCategory(id = "1", title = "Camisetas", MainActivity().fillRvProduct()),
            ProductCategory(id = "2", title = "Calças", MainActivity().fillRvProduct()),
            ProductCategory(id = "3", title = "Tenis", MainActivity().fillRvProduct()),
            ProductCategory(id = "4", title = "Biquinis", MainActivity().fillRvProduct()),
            ProductCategory(id = "5", title = "Sapatos", MainActivity().fillRvProduct()),
            ProductCategory(id = "6", title = "Eletrônicos", MainActivity().fillRvProduct()),
            ProductCategory(id = "7", title = "Músicas", MainActivity().fillRvProduct()),
            ProductCategory(id = "8", title = "Games", MainActivity().fillRvProduct()),
            ProductCategory(id = "9", title = "Filmes", MainActivity().fillRvProduct()),
            ProductCategory(id = "10", title = "Livros", MainActivity().fillRvProduct())
        )

        val adapterCategory = ProductCategoryAdapter(arrayCategory, requireContext())

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(requireContext(), 2)

        return view;
    }

    interface CallBack{
        fun itemSelected(category: ProductCategory)
    }

}