package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lab2.fragments.Ex1Fragment;
import com.example.lab2.fragments.Ex2Fragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Ex1Fragment();
            case 1:
                return new Ex2Fragment();
            default:
                return new Ex1Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
