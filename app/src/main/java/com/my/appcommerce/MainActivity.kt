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
import com.my.appcommerce.adapter.ProductCategoryAdapter
import com.my.appcommerce.model.ProductCategory


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar;
    lateinit var drawerLayout: DrawerLayout;
    lateinit var navigationView: NavigationView;
    lateinit var textTitle: TextView;
    lateinit var textLogin: TextView;
    lateinit var recyclerCategory: RecyclerView;


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

        val productItem: LinearLayout = findViewById(R.id.ll_product_item)
        productItem.setOnClickListener{
            val intent: Intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener{
            val intent: Intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

        recyclerCategory = findViewById(R.id.rv_main_product_category)

        val arrayCategory = arrayListOf<ProductCategory>(
            ProductCategory(id = "1", title = "Camisetas"),
            ProductCategory(id = "2", title = "Calças"),
            ProductCategory(id = "3", title = "Tenis"),
            ProductCategory(id = "4", title = "Biquinis"),
            ProductCategory(id = "5", title = "Sapatos"),
            ProductCategory(id = "6", title = "Eletrônicos"),
            ProductCategory(id = "7", title = "Eletrodomesticos"),
            ProductCategory(id = "8", title = "Games"),
            ProductCategory(id = "9", title = "Filmes"),
            ProductCategory(id = "10", title = "Livros")
        )

        val adapterCategory = ProductCategoryAdapter(arrayCategory, this)

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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
}