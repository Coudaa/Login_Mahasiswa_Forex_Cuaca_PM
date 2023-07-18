package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.tablayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.R;
import com.google.android.material.tabs.TabLayout;

public class TabMainActivity extends AppCompatActivity {
    private MyFragmentPageAdapter _myFragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_main);

        TabLayout tabLayout1 = findViewById(R.id.tabLayout1);
        tabLayout1.addTab(tabLayout1.newTab().setText("Tab 1"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Tab 2"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Tab 3"));
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager1 = findViewById(R.id.viewPager1);

        _myFragmentPageAdapter = new MyFragmentPageAdapter(this, getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(_myFragmentPageAdapter);
        viewPager1.setOffscreenPageLimit(3);

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}