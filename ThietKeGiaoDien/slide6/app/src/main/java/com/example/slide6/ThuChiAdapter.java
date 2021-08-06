package com.example.slide6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ThuChiAdapter extends FragmentStatePagerAdapter {


    public ThuChiAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return "Thu";
            case 1:  return "Chi";
            case 2: return "Quy den";
            case 3: return "Thu";
            case 4:  return "Chi";
            case 5: return "Quy den";
        }
        return super.getPageTitle(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new BlankFragment();
            case 1: return new Blank1Fragment();
            case 2: return new Blank2Fragment();
            case 3: return new BlankFragment();
            case 4: return new Blank1Fragment();
            case 5: return new Blank2Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
