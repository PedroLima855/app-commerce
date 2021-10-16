package com.my.appcommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.appcommerce.adapter.ProductCategoryAdapter
import com.my.appcommerce.model.ProductCategory

class ProductCategoryActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var recyclerCategory: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_category)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.product_dategory_title)

        recyclerCategory = findViewById(R.id.rv_product_category)

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

        val adapterCategory = ProductCategoryAdapter(arrayCategory, this)

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true;
    }
}