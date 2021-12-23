package com.my.appcommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.appcommerce.adapter.ProductCategoryAdapter
import com.my.appcommerce.model.Product
import com.my.appcommerce.model.ProductCategory

class ProductActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var recyclerCategory: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.product_title)

        val category = intent.getSerializableExtra("CATEGORY") as ProductCategory

        val args = Bundle()
        args.putSerializable("CATEGORY", category)

        val fragment = ProductFragment()
        fragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_product, fragment)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true;
    }
}