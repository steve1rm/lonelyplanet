package me.androidbox.travelmate;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int NUM_PAGES = 5;
    private List<Fragment> mFragmentList = Collections.emptyList();

    private ImageView mIvCircle0;
    private ImageView mIvCircle1;
    private ImageView mIvCircle2;
    private ImageView mIvCircle3;
    private ImageView mIvCircle4;
    private Button mBtnExploreCities;

    private int mPreviousPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        setContentView(R.layout.screen_slide);

        /* Create an arrayList of fragments that will be used for the viewpager to navigate through */
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new LoginFragment());
        mFragmentList.add(new CitiesFragment());
        mFragmentList.add(new FavouriteFragment());
        mFragmentList.add(new MapsFragment());
        mFragmentList.add(new OfflineFragment());

        mIvCircle0 = (ImageView)findViewById(R.id.circle0);
        mIvCircle1 = (ImageView)findViewById(R.id.circle1);
        mIvCircle2 = (ImageView)findViewById(R.id.circle2);
        mIvCircle3 = (ImageView)findViewById(R.id.circle3);
        mIvCircle4 = (ImageView)findViewById(R.id.circle4);

        /* Clear all animations */
        mIvCircle0.clearAnimation();
        mIvCircle1.clearAnimation();
        mIvCircle2.clearAnimation();
        mIvCircle3.clearAnimation();
        mIvCircle4.clearAnimation();

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new ScreenSlidePageAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
        mIvCircle0.startAnimation(scaleAnim);
        scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
        mIvCircle1.startAnimation(scaleAnim);
        scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
        mIvCircle2.startAnimation(scaleAnim);
        scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
        mIvCircle3.startAnimation(scaleAnim);
        scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
        mIvCircle4.startAnimation(scaleAnim);

        mBtnExploreCities = (Button)findViewById(R.id.btnExploreCities);
        mBtnExploreCities.setVisibility(View.INVISIBLE);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /* Ignore */
            }

            @Override
            public void onPageSelected(int position) {
                boolean moveRight = false;
                /* if the position is greater than mPreviousPosition we are moving right */
                if (position > mPreviousPosition) {
                    moveRight = true;
                }

                Log.d(TAG, "onPageSelected position " + position);
                switch(position) {
                    case 0:
                        if (moveRight) {
                            Log.d(TAG, "MoveRight");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle0.startAnimation(scaleAnim);
                        }
                        else {
                            Log.d(TAG, "MoveLeft");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle0.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle1.startAnimation(scaleAnim);
                        }
                        break;

                    case 1:
                        if (moveRight) {
                            Log.d(TAG, "moveRight");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle0.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle1.startAnimation(scaleAnim);
                        }
                        else {
                            Log.d(TAG, "moveLeft");

                            Log.d(TAG, "onPerformAnimation moveLeft");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle1.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle2.startAnimation(scaleAnim);
                        }
                        break;

                    case 2:
                        if (moveRight) {
                            Log.d(TAG, "moveRight");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle1.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle2.startAnimation(scaleAnim);
                        }
                        else {
                            Log.d(TAG, "moveLeft");

                            Log.d(TAG, "onPerformAnimation moveLeft");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle2.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle3.startAnimation(scaleAnim);
                        }
                        break;

                    case 3:
                        if (moveRight) {
                            Log.d(TAG, "moveRight");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle2.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle3.startAnimation(scaleAnim);
                        }
                        else {
                            Log.d(TAG, "moveLeft");

                            Log.d(TAG, "onPerformAnimation moveLeft");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle3.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle4.startAnimation(scaleAnim);

                            final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_disappear);
                            mBtnExploreCities.startAnimation(animation);
                        }
                        break;

                    case 4:
                        if (moveRight) {
                            Log.d(TAG, "moveRight");
                            Animation scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaledown_circle);
                            mIvCircle3.startAnimation(scaleAnim);

                            scaleAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleup_circle);
                            mIvCircle4.startAnimation(scaleAnim);

                            mBtnExploreCities.setVisibility(View.VISIBLE);

                            final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_appear);
                            mBtnExploreCities.startAnimation(animation);
                        }
                        else {
                            Log.d(TAG, "moveLeft");
                        }
                        break;
                }

                /* Update mPreviousPosition */
                mPreviousPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /* Ignore */
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
