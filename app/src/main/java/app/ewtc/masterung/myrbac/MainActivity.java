package app.ewtc.masterung.myrbac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.ewtc.masterung.myrbac.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Fragment
        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainContainer, mainFragment)
                    .commit();
        }

    }   // Main Method

}   // Main Class
