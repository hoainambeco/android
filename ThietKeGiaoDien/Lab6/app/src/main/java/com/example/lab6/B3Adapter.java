package com.example.lab6;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class B3Adapter extends FragmentStatePagerAdapter {


    public B3Adapter(@NonNull FragmentManager fm){
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return "TAB1";
            case 1:  return "TAB2";
            case 2: return "TAB3";
        }
        return super.getPageTitle(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new B3_Frag0();
            case 1: return new B3_Frag1();
            case 2: return new B3_Frag2();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 3;
    }
}
