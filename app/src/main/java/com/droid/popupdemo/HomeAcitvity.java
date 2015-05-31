package com.droid.popupdemo;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


public class HomeAcitvity extends ActionBarActivity implements View.OnClickListener{

    private static final String LOG_TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitvity);
        Button popupButton = (Button)findViewById(R.id.popup);
        popupButton.setOnClickListener(this);
        Button alertButton = (Button)findViewById(R.id.alertdialog);
        alertButton.setOnClickListener(this);
        Button customalertButton = (Button)findViewById(R.id.customalertdialog);
        customalertButton.setOnClickListener(this);
        Button progressDialogButton = (Button)findViewById(R.id.progressdialog);
        progressDialogButton.setOnClickListener(this);
        Button pbarDialogButton = (Button)findViewById(R.id.pbardialog);
        pbarDialogButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_acitvity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.popup:
                DialogUtils.constructPopUp(this);
            break;

            case R.id.alertdialog:
                DialogUtils.constructAlertDialog(this);
                break;

            case R.id.customalertdialog:
                DialogUtils.constructCustomAlertdialog(this);
                break;

            case R.id.progressdialog:
                DialogUtils.constructProgressDialog(this, ProgressDialog.STYLE_SPINNER);
                break;

            case R.id.pbardialog:
                DialogUtils.constructProgressDialog(this,ProgressDialog.STYLE_HORIZONTAL);
                break;
        }
    }

}
