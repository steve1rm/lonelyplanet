package me.androidbox.travelmate;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int NUM_PAGES = 5;
    private ViewPager mViewPager;
    private PagerAdapter mPageAdapter;
    private List<Fragment> mFragmentList = Collections.emptyList();
    private PerformAnimationListener mPerformAnimationListener0;
    private PerformAnimationListener mPerformAnimationListener1;
    private PerformAnimationListener mPerformAnimationListener2;
    private PerformAnimationListener mPerformAnimationListener3;
    private PerformAnimationListener mPerformAnimationListener4;
    private int mPreviousPosition;

    private List<PerformAnimationListener> mPerformAnimationListenersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        setContentView(R.layout.screen_slide);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new LoginFragment());
        mFragmentList.add(new CitiesFragment());
        mFragmentList.add(new FavouriteFragment());
        mFragmentList.add(new MapsFragment());
        mFragmentList.add(new OfflineFragment());

/*
        mPerformAnimationListenersList = new ArrayList<>();
        mPerformAnimationListenersList.add(mPerformAnimationListener0);
        mPerformAnimationListenersList.add(mPerformAnimationListener1);
        mPerformAnimationListenersList.add(mPerformAnimationListener2);
        mPerformAnimationListenersList.add(mPerformAnimationListener3);
        mPerformAnimationListenersList.add(mPerformAnimationListener4);

        mPerformAnimationListenersList.get(0) = (PerformAnimationListener)mFragmentList.get(0);
*/

        mPerformAnimationListener0 = (PerformAnimationListener)mFragmentList.get(0);
        mPerformAnimationListener1 = (PerformAnimationListener)mFragmentList.get(1);
        mPerformAnimationListener2 = (PerformAnimationListener)mFragmentList.get(2);
        mPerformAnimationListener3 = (PerformAnimationListener)mFragmentList.get(3);
        mPerformAnimationListener4 = (PerformAnimationListener)mFragmentList.get(4);


     //   for(Fragment fragment : mFragmentList) {
     //       mPerformAnimationListener = (PerformAnimationListener)fragment;
     //   }

      /*  int i = 0;
        for(PerformAnimationListener performAnimationListener : mPerformAnimationListenersList) {
            performAnimationListener = (PerformAnimationListener)mFragmentList.get(i);
            i++;
        }*/

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mPageAdapter = new ScreenSlidePageAdapter(getFragmentManager());
        mViewPager.setAdapter(mPageAdapter);

/*
        mViewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(TAG, "onScrollChange");
            }
        });
*/

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Log.d(TAG, "onPageScrolled position " + position);
            }

            @Override
            public void onPageSelected(int position) {

                boolean moveRight = false;
                /* if the position is greater than mPreviousPosition we are moving right */
                if(position > mPreviousPosition) {
                    moveRight = true;
                    Log.d(TAG, "MoveRight");
                }

                Log.d(TAG, "onPageSelected position " + position);
                switch(position) {
                    case 0:
                        mPerformAnimationListener0.onPerformAnimation(moveRight);
                        break;

                    case 1:
                        mPerformAnimationListener1.onPerformAnimation(moveRight);
                        break;

                    case 2:
                        mPerformAnimationListener2.onPerformAnimation(moveRight);
                        break;

                    case 3:
                        mPerformAnimationListener3.onPerformAnimation(moveRight);
                        break;

                    case 4:
                        mPerformAnimationListener4.onPerformAnimation(moveRight);
                        break;
                }

                /* Update mPreviousPosition */
                mPreviousPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Log.d(TAG, "onPageScrollStateChanged state " + state);
            }
        });
    }

    public class ScreenSlidePageAdapter extends FragmentPagerAdapter {
        private final String TAG = ScreenSlidePageAdapter.class.getSimpleName();

        public ScreenSlidePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(TAG, "getItem: " + position);
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
