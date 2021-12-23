package com.my.appcommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.appcommerce.adapter.ProductAdatpter
import com.my.appcommerce.model.Product
import com.my.appcommerce.model.ProductCategory

class ProductFragment : Fragment() {

    lateinit var recyclerProduct: RecyclerView
    lateinit var arrayProduct: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(arguments != null){
            arrayProduct = (arguments?.getSerializable("CATEGORY") as ProductCategory ).products
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_product, container, false);

        recyclerProduct = view.findViewById(R.id.rv_product)

        val adapterProduct = ProductAdatpter(arrayProduct, requireContext())

        recyclerProduct.adapter = adapterProduct
        recyclerProduct.layoutManager = GridLayoutManager(requireContext(), 3)

        return view
    }
}