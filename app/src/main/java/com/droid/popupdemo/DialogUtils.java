package com.droid.popupdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by pallavi on 4/10/2015.
 */
public class DialogUtils {

    //TODO : DatePicker and TimePicker dialogs are recommended to be used with DialogFragment. Will be done later

    private static final String  LOG_TAG = "DialogUtils";

    /*
    * PopUpWindow does not has LTR and RTL support
    * */
    public static void constructPopUp(Context context){
        Log.d(LOG_TAG,"Constructing pop up window ");
        PopupWindow popupWindow = new PopupWindow(800, RelativeLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(android.R.color.holo_blue_dark));
        View view = ((Activity)context).getLayoutInflater().inflate(R.layout.popuplayout,null);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(view, Gravity.TOP,0,0);

    }

    public static void constructAlertDialog(final Context context){
        Log.d(LOG_TAG,"Constructing alert dialog");
        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.alertdialogtitle))
        .setMessage("Would you like the give feedback ?")
        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"Feeback sent ",Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Feeback not sent  ", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        builder.create().show();
    }

    public static void constructCustomAlertdialog(final Context context){
        Log.d(LOG_TAG,"Constructing alert dialog");
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.alertdialogtitle))
                .setCustomTitle(inflater.inflate(R.layout.alertcustomtitle, null))
                .setMessage("Start android programming ?")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "May be .... ", Toast.LENGTH_SHORT).show();

                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Start tutorials on android ", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Not interested... it seems ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }

    public static void constructProgressDialog(final Context context,int style){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading ");
        progressDialog.setProgressStyle(style);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

}
