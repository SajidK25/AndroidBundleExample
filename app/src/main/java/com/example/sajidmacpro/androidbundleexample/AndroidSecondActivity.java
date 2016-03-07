package com.example.sajidmacpro.androidbundleexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sajidMacPro on 3/1/16.
 */
public class AndroidSecondActivity extends AppCompatActivity{
    public TextView showName, showPhoneNumber, age, showIsMarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initializeViews();

        Intent in = getIntent();

        Bundle b = in.getExtras();

        String nameString = b.getString("fullname");

        String phoneNumberString = Long.toString(b.getLong("phoneNumber"));
;
        String ageString = Double.toString(b.getDouble("age"));

        boolean isMarriedBoolean = b.getBoolean("married");


        showName.setText("Name : " + nameString);
        showPhoneNumber.setText("Phone number : " + phoneNumberString);
        age.setText("Age : " + ageString);
        showIsMarried.setText("Is married : " + isMarriedBoolean);
    }

    public void initializeViews() {
        showName = (TextView) findViewById(R.id.showName);
        showPhoneNumber = (TextView) findViewById(R.id.showPhoneNumber);
        age = (TextView) findViewById(R.id.showAge);
        showIsMarried = (TextView) findViewById(R.id.showIsMarried);

    }

}
