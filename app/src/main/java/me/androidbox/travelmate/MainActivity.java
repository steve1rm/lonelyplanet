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

    public enum CustomPagerEnum {
        RED(R.string.cities, R.layout.fragment_cities),
        BLUE(R.string.favourites, R.layout.fragment_favourite),
        ORANGE(R.string.offline, R.layout.fragment_offline);

        private int mTitleResId;
        private int mLayoutResId;

        CustomPagerEnum(int titleResId, int layoutResId) {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }

    }
    public class CustomPagerAdapter extends PagerAdapter {
        private Context mContext;

        public CustomPagerAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup)inflater.inflate(customPagerEnum.getLayoutResId(), container, false);
            container.addView(layout);

            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View)view);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            super.getPageTitle(position);
            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            return mContext.getString(customPagerEnum.getTitleResId());
        }

        @Override
        public int getCount() {
            return CustomPagerEnum.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
