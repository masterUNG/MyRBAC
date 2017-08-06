package app.ewtc.masterung.myrbac.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.ewtc.masterung.myrbac.R;

/**
 * Created by masterung on 8/6/2017 AD.
 */

public class SignUpFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        return view;

    }   // onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Controller
        ImageView imageView = getView().findViewById(R.id.imvBack);


    }
}   // Main Class
