package app.ewtc.masterung.myrbac.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import app.ewtc.masterung.myrbac.R;
import app.ewtc.masterung.myrbac.manager.GetData;
import app.ewtc.masterung.myrbac.manager.MyAlert;

/**
 * Created by masterung on 8/5/2017 AD.
 */

public class MainFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;

    }   // onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register Controller
        registerController();

        //SignIn Controller
        signInController();

    }

    private void signInController() {
        Button button = getView().findViewById(R.id.btnSignIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String strUser = userEditText.getText().toString().trim();
                String strPassword = passwordEditText.getText().toString().trim();

                if (strUser.equals("") || strPassword.equals("")) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "Please Fill All Blank");
                } else {
                    checkUserAndPass(strUser, strPassword);
                }


            }
        });
    }

    private void checkUserAndPass(String strUser, String strPassword) {

        try {

            GetData getData = new GetData(getActivity());
            getData.execute(strUser, "http://androidthai.in.th/rbac/getValueWhereUser.php");
            String strResult = getData.get();
            Log.d("6AugV1", "Result ==> " + strResult);

            if (strResult.equals("null")) {
                MyAlert myAlert = new MyAlert(getActivity());
                myAlert.myDialog("User False", "No " + strUser + " in my Database");
            } else {

                JSONArray jsonArray = new JSONArray(strResult);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String truePassWord = jsonObject.getString("Password");

                if (strPassword.equals(truePassWord)) {

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.mainContainer, new ServiceFragment())
                            .commit();

                } else {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Password Fale", "Please Try Again Password False");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignUpFragment signUpFragment = new SignUpFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainContainer, signUpFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });


    }
}   // Main Class นี่คือ คลาสหลัก
