package me.androidbox.travelmate;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CitiesFragment extends Fragment {
    private static final String TAG = CitiesFragment.class.getSimpleName();

    private ImageView mIvCircle1;
    private ImageView mIvCircle2;

    public CitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cities, container, false);
        mIvCircle1 = (ImageView)view.findViewById(R.id.circle1);
        mIvCircle2 = (ImageView)view.findViewById(R.id.circle2);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        final Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
        mIvCircle2.startAnimation(scaleAnim);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        final Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
        mIvCircle1.startAnimation(scaleAnim);
    }

}
