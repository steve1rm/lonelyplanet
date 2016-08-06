package me.androidbox.travelmate.view;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import me.androidbox.travelmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getSimpleName();

    private Toolbar toolbar;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        final AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);

        final ImageView ivLogo = (ImageView)view.findViewById(R.id.ivLogo);
        final ImageView ivSearch = (ImageView)view.findViewById(R.id.ivSearch);
        final ImageView ivSettings = (ImageView)view.findViewById(R.id.ivSettings);
        final ScrollView nsvCities = (ScrollView)view.findViewById(R.id.nsvCities);
        final TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float width = displayMetrics.xdpi;
        final float height = displayMetrics.ydpi;
        final float widthPx = displayMetrics.widthPixels;
        final Point size = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);
        Log.d(TAG, "width: " + width + " height: " + height + " widthPx: " + widthPx + " sizeX: " + size.x + " sizeY: " + size.y + " toolbar: " + toolbar.getWidth());

        final float rawPX20DPValue = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());

        final float rawPX20PValue = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 ,getResources().getDisplayMetrics());

        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "toolbar.getHeight(): " + toolbar.getHeight() + "toolbar.getMinimumHeight(): " + toolbar.getMinimumHeight());

                final Animation animation= AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_logo);
                ivLogo.startAnimation(animation);

                ivSearch.animate()
                        .setInterpolator(new AccelerateInterpolator())
                        .translationX(-60)
                        .translationY(0)
                        .setDuration(250)
                        .start();

                ivSettings.animate()
                        .setInterpolator(new AccelerateInterpolator())
                        .translationX(60)
                        .translationY(0)
                        .setDuration(250)
                        .start();
            }
        });

        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)toolbar.getLayoutParams();



   /*     nsvCities.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(TAG, "onScrollChange scrollX " + scrollX + " scrollY: " + scrollY);

                if(scrollY > 0 && scrollY <= 30) {
                    layoutParams.height = scrollY * 10;
                    toolbar.setLayoutParams(layoutParams);
                    toolbar.requestLayout();
                }
            }
        });*/

        return view;
    }
}
