package com.android.aprenda_ingles.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.android.aprenda_ingles.R
import com.android.aprenda_ingles.fragment.BichosFragment
import com.android.aprenda_ingles.fragment.NumerosFragment
import com.android.aprenda_ingles.fragment.VogaisFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class MainActivity : AppCompatActivity() {

    lateinit var smartTabLayout : SmartTabLayout;
    lateinit var viewPager : ViewPager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smartTabLayout = findViewById(R.id.smartTabLayout);
        viewPager = findViewById(R.id.viewPager);

        //Removendo a sobra da ActionBar
        supportActionBar?.elevation = 0F;

        val adapter = FragmentPagerItemAdapter(supportFragmentManager, FragmentPagerItems.with(this)
            .add("Bichos", BichosFragment::class.java)
            .add("Números",NumerosFragment::class.java)
            .add("Vogais", VogaisFragment::class.java)
            .create());

        viewPager.adapter = adapter;
        smartTabLayout.setViewPager(viewPager);

    }
}
