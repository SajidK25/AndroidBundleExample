package com.example.sajidmacpro.androidbundleexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText name, phone_no, age;
    public CheckBox married;

    public String fullname, phoneNumber, ageBirth;
    public boolean isMarried = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeEditTexts();

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDataFromForm();

                if (name.length() == 0 || phone_no.length() == 0 || age.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Complete the form correctly", Toast.LENGTH_SHORT).show();
                } else {

                    long phone = Long.parseLong(phoneNumber);
                    double ageDouble = Long.parseLong(ageBirth);

                    Bundle b = new Bundle();
                    b.putString("fullname", fullname);
                    b.putLong("phoneNumber", phone);
                    b.putDouble("age", ageDouble);
                    b.putBoolean("married", isMarried);

                    Intent in = new Intent(MainActivity.this, AndroidSecondActivity.class);
                    in.putExtras(b);
                    startActivity(in);
                }
            }
        });
    }

    public void initializeEditTexts() {
        name = (EditText) findViewById(R.id.name);
        phone_no = (EditText) findViewById(R.id.phone_no);
        age = (EditText) findViewById(R.id.age);
        married = (CheckBox) findViewById(R.id.married);
    }

    public void getDataFromForm() {
        fullname = name.getText().toString();
        phoneNumber = phone_no.getText().toString();
        ageBirth = age.getText().toString();
        isMarried = married.isChecked();
    }

}