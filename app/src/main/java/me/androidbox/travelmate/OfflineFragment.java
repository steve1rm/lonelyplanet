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
public class OfflineFragment extends Fragment implements PerformAnimationListener {
    private ImageView mIvCircle4;
    private ImageView mIvCircle5;


    public OfflineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_maps, container, false);

        mIvCircle4 = (ImageView)view.findViewById(R.id.circle4);
        mIvCircle5 = (ImageView)view.findViewById(R.id.circle5);

        return view;
    }

    @Override
    public void onPerformAnimation() {
        Animation scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaleup_circle);
        mIvCircle5.startAnimation(scaleAnim);

        scaleAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scaledown_circle);
        mIvCircle4.startAnimation(scaleAnim);

    }
}
