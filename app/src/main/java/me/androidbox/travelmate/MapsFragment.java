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
public class MapsFragment extends Fragment implements PerformAnimationListener {
    private ImageView mIvCircle3;
    private ImageView mIvCircle4;
    private ImageView mIvCircle5;

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_maps, container, false);

 /*       mIvCircle3 = (ImageView)view.findViewById(R.id.circle3);
        mIvCircle4 = (ImageView)view.findViewById(R.id.circle4);
        mIvCircle5 = (ImageView)view.findViewById(R.id.circle5);

        mIvCircle3.clearAnimation();
        mIvCircle4.clearAnimation();
        mIvCircle5.clearAnimation();
*/
        return view;
    }

    @Override
    public void onPerformAnimation(boolean moveRight) {
  /*      if(moveRight) {
            Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
            mIvCircle4.startAnimation(scaleAnim);

            scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
            mIvCircle3.startAnimation(scaleAnim);
        }
        else {
            Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
            mIvCircle4.startAnimation(scaleAnim);

            scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
            mIvCircle5.startAnimation(scaleAnim);
        }
*/    }

    @Override
    public void onPause() {
        super.onPause();
/*
        mIvCircle3.clearAnimation();
        mIvCircle5.clearAnimation();
        mIvCircle4.clearAnimation();
*/
    }

}
