package app.ewtc.masterung.myrbac.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import app.ewtc.masterung.myrbac.R;

/**
 * Created by masterung on 8/6/2017 AD.
 */

public class MyAlert {

    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_name);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();


    }


}   // Main Class
