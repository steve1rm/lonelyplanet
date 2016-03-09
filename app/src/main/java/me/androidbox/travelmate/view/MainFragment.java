package me.androidbox.travelmate.view;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import me.androidbox.travelmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_main, container, false);

        final Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        final AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);

        final ImageView ivLogo = (ImageView)view.findViewById(R.id.ivLogo);
        final ImageView ivSearch = (ImageView)view.findViewById(R.id.ivSearch);
        final ImageView ivSettings = (ImageView)view.findViewById(R.id.ivSettings);
        final NestedScrollView nsvCities = (NestedScrollView)view.findViewById(R.id.nsvCities);
        final TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float width = displayMetrics.xdpi;
        final float height = displayMetrics.ydpi;
        final float widthPx = displayMetrics.widthPixels;
        final Point size = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);
        Log.d(TAG, "width: " + width + " height: " + height + " widthPx: " + widthPx + " sizeX: " + size.x + " sizeY: " + size.y + " toolbar: " + toolbar.getWidth());

        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation animation= AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_logo);
                ivLogo.startAnimation(animation);

                ivSearch.animate()
                        .setInterpolator(new AccelerateInterpolator())
                        .x(20)
                        .y(20)
                        .setDuration(250)
                        .start();

                ivSettings.animate()
                        .setInterpolator(new AccelerateInterpolator())
                        .x(widthPx - 160)
                        .y(20)
                        .setDuration(250)
                        .start();
            }
        });

        nsvCities.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d(TAG, "onScrollChange");
            }
        });

        return view;
    }
}
