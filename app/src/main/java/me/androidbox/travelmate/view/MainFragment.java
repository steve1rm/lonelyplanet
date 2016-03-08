package me.androidbox.travelmate.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import me.androidbox.travelmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String TAG = MainFragment.class.getSimpleName();

    private Scene mToolbar_expanded;
    private Scene mToolbar_collapsed;

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

        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation animation= AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_logo);
                ivLogo.startAnimation(animation);

                ivSearch.animate()
                        .x(20)
                        .y(20)
                        .setDuration(250)
                        .start();

                ivSettings.animate()
                        .x(380)
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

/*
        mToolbar_expanded = Scene.getSceneForLayout((ViewGroup)view.findViewById(R.id.scene_root), R.layout.toolbar_scene_expanded, getActivity());
        mToolbar_collapsed = Scene.getSceneForLayout((ViewGroup)view.findViewById(R.id.scene_root), R.layout.toolbar_scene_collapsed, getActivity());
        mToolbar_expanded.enter();
*/

        return view;
    }
}
