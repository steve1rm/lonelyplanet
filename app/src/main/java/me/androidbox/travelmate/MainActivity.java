package me.androidbox.travelmate;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 5;
    private ViewPager mViewPager;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_slide);

        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mPageAdapter = new ScreenSlidePageAdapter(getFragmentManager());
        mViewPager.setAdapter(mPageAdapter);
    }

    public static class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragmentList = Collections.emptyList();

        public ScreenSlidePageAdapter(FragmentManager fm) {
            super(fm);
            fragmentList = new ArrayList<>();

            fragmentList.add(new LoginFragment());
            fragmentList.add(new CitiesFragment());
            fragmentList.add(new FavouriteFragment());
            fragmentList.add(new MapsFragment());
            fragmentList.add(new OfflineFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


}
