package me.androidbox.travelmate.view;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.androidbox.travelmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private Scene mToolbar_expanded;
    private Scene mToolbar_collapsed;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        final AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);


        mToolbar_expanded = Scene.getSceneForLayout((ViewGroup)view.findViewById(R.id.scene_root), R.layout.toolbar_scene_expanded, getActivity());
        mToolbar_collapsed = Scene.getSceneForLayout((ViewGroup)view.findViewById(R.id.scene_root), R.layout.toolbar_scene_collapsed, getActivity());

        mToolbar_expanded.enter();

        return view;
    }
}
