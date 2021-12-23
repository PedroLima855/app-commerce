package com.my.appcommerce

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.my.appcommerce.adapter.ProductAdatpter
import com.my.appcommerce.adapter.ProductCategoryAdapter
import com.my.appcommerce.model.Product
import com.my.appcommerce.model.ProductCategory
import com.my.appcommerce.model.ProductColor
import com.my.appcommerce.model.ProductSize


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ProductCategoryFragment.CallBack {

    lateinit var toolbar: Toolbar;
    lateinit var drawerLayout: DrawerLayout;
    lateinit var navigationView: NavigationView;
    lateinit var textTitle: TextView;
    lateinit var textLogin: TextView;
    lateinit var recyclerCategory: RecyclerView;
    lateinit var recyclerProduct: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.app_name)

        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.toggle_open, R.string.toggle_close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener{
            val intent: Intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

        recyclerCategory = findViewById(R.id.rv_main_product_category)

        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory(id = "1", title = "Camisetas", fillRvProduct()),
            ProductCategory(id = "2", title = "Calças", fillRvProduct()),
            ProductCategory(id = "3", title = "Tenis", fillRvProduct()),
            ProductCategory(id = "4", title = "Biquinis", fillRvProduct()),
            ProductCategory(id = "5", title = "Sapatos", fillRvProduct()),
            ProductCategory(id = "6", title = "Eletrônicos", fillRvProduct()),
            ProductCategory(id = "7", title = "Eletrodomesticos", fillRvProduct()),
            ProductCategory(id = "8", title = "Games",fillRvProduct()),
            ProductCategory(id = "9", title = "Filmes", fillRvProduct()),
            ProductCategory(id = "10", title = "Livros", fillRvProduct())
        )

        val adapterCategory = ProductCategoryAdapter(arrayCategory, this)

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerProduct = findViewById(R.id.rv_main_product)

        val adapterProduct =  ProductAdatpter(fillRvProduct(), this)

        recyclerProduct.adapter = adapterProduct
        recyclerProduct.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    fun fillRvProduct(): List<Product> {

        val product1: Product = Product(
            "1",
            "Camiseta 89",
            ProductCategory("id", "Camisetas"),
            "Camiseta super leve para fazer exercicios.",
            19.90,
            arrayListOf(ProductColor("1", "Branco", "#ffffff"), ProductColor("2", "Preta", "#000000")),
            arrayListOf(ProductSize("1", "P"), ProductSize("1", "M")),
            emptyList())

        val product2: Product = Product(
            "1",
            "Calça Jeans",
            ProductCategory("id", "Calças"),
            "Calça impermeavel com proteção de chuva",
            109.00,
            arrayListOf(ProductColor("1", "Branco", "#ffffff"), ProductColor("2", "Preta", "#000000")),
            arrayListOf(ProductSize("1", "G"), ProductSize("1", "GG")),
            emptyList())

        return arrayListOf(product1, product2)
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_account -> {
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_category -> {
                val intent = Intent(this, ProductCategoryActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_orders -> Toast.makeText(this, "Compras", Toast.LENGTH_LONG).show()
            R.id.nav_cart -> {
                val intent = Intent(this, ProductDetailActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_logout -> Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        return true;
    }

    override fun itemSelected(category: ProductCategory) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}