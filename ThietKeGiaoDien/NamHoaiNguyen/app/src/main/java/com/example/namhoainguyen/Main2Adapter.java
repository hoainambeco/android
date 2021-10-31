package com.example.namhoainguyen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Main2Adapter extends FragmentStatePagerAdapter {


    public Main2Adapter(@NonNull FragmentManager fm){
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:  return "THÊM";
            case 1:  return "DANH SÁCH";
        }
        return super.getPageTitle(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new ThemFragment();
            case 1: return new FragmentDanhsach();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 2;
    }
}
