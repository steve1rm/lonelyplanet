package me.androidbox.travelmate.view;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.androidbox.travelmate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
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

        return view;
    }
}
