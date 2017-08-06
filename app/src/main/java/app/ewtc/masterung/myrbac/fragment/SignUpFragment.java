package app.ewtc.masterung.myrbac.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import app.ewtc.masterung.myrbac.R;
import app.ewtc.masterung.myrbac.manager.MyAlert;

/**
 * Created by masterung on 8/6/2017 AD.
 */

public class SignUpFragment extends Fragment {

    private String nameString, userString, passwordString;

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
        backController();

        //Save Controller
        saveController();


    }

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From EditText
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                MyAlert myAlert = new MyAlert(getActivity());

                //Check Space
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                    //Have Space
                    Log.d("6AugV1", "Have Space");
                    myAlert.myDialog("Have Space", "Please Fill All Every Blank");

                } else {
                    //No Space
                    Log.d("6AugV1", "No Space");

                }



            }   // onClick
        });
    }

    private void backController() {
        ImageView imageView = getView().findViewById(R.id.imvBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}   // Main Class
