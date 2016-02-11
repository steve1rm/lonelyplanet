package me.androidbox.travelmate;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
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
public class LoginFragment extends Fragment implements PerformAnimationListener {
    private static final String TAG = LoginFragment.class.getSimpleName();

    private ImageView mIvCircle1;
    private ImageView mIvCircle2;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        mIvCircle1 = (ImageView)view.findViewById(R.id.circle1);
        mIvCircle2 = (ImageView)view.findViewById(R.id.circle2);

        return view;
    }

    @Override
    public void onPerformAnimation() {
        Log.d(TAG, "onPerformAnimation");
        Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
        mIvCircle1.startAnimation(scaleAnim);

        scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
        mIvCircle2.startAnimation(scaleAnim);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
 //       final Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
 //       mIvCircle.startAnimation(scaleAnim);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

 //       mIvCircle.clearAnimation();
    }




}
