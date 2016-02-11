package me.androidbox.travelmate;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment implements PerformAnimationListener {
    private ImageView mIvCircle2;
    private ImageView mIvCircle3;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        mIvCircle2 = (ImageView)view.findViewById(R.id.circle2);
        mIvCircle3 = (ImageView)view.findViewById(R.id.circle3);

        return view;
    }

    @Override
    public void onPerformAnimation() {
        Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
        mIvCircle3.startAnimation(scaleAnim);

        scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
        mIvCircle2.startAnimation(scaleAnim);

    }
}
