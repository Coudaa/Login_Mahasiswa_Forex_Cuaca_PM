package com.alfonsusjericho_202102286.login_mahasiswa_forex_cuaca.tablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private Fragment1 _fragment1 = new Fragment1();
    private fragment2 _fragment2 = new fragment2();
    private fragment3 _fragment3 = new fragment3();
    private Context _context;
    private int _tabcount;

    public MyFragmentPageAdapter (Context context, FragmentManager fragmentManager, int tabcount){
        super(fragmentManager);
        _context = context;
        _tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return _fragment1;
            case 1:
                return _fragment2;
            default:
                return _fragment3;
        }
    }

    @Override
    public int getCount() {
        return _tabcount;
    }
}
