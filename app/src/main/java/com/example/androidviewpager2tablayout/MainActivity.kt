package com.example.androidviewpager2tablayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val websites = arrayListOf<MyWebsite>(
        MyWebsite("Yandex", R.drawable.yandex, "https://ya.ru/"),
        MyWebsite("YouTube", R.drawable.you_tube, "https://www.youtube.com/"),
        MyWebsite("GitHub", R.drawable.github, "https://github.com/"),
        MyWebsite(
            "Urban University",
            R.drawable.urban_university,
            "https://urban-university.ru/"
        )
    )
    private lateinit var adapter: WebPageAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        adapter = WebPageAdapter(this, websites)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            val name = websites[position].name
            tab.text = name
        }.attach()
    }
}