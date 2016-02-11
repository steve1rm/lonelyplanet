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
public class CitiesFragment extends Fragment implements PerformAnimationListener {
    private static final String TAG = CitiesFragment.class.getSimpleName();

    private ImageView mIvCircle1;
    private ImageView mIvCircle2;
    private ImageView mIvCircle3;

    public CitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_cities, container, false);
        mIvCircle1 = (ImageView)view.findViewById(R.id.circle1);
        mIvCircle2 = (ImageView)view.findViewById(R.id.circle2);
        mIvCircle3 = (ImageView)view.findViewById(R.id.circle3);

        mIvCircle3.clearAnimation();
        mIvCircle2.clearAnimation();
        mIvCircle1.clearAnimation();

        return view;
    }

    @Override
    public void onPerformAnimation(boolean moveRight) {
        if(moveRight) {
            Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
            mIvCircle2.startAnimation(scaleAnim);

            scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
            mIvCircle1.startAnimation(scaleAnim);
        }
        else {
            Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
            mIvCircle2.startAnimation(scaleAnim);

            scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
            mIvCircle3.startAnimation(scaleAnim);
        }

    }

}
