package com.celikel.buttonchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onBtnClick(View view) {
        TextView firstNameText = findViewById(R.id.fistNameTextView);
        EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        firstNameText.setText("First Name:" + firstNameEditText.getText().toString());

        TextView lastNameText = findViewById(R.id.lastNameTextView);
        EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        lastNameText.setText("Last Name:" + lastNameEditText.getText().toString());

        TextView emailTextView = findViewById(R.id.emailTextView);
        EditText emailEditText = findViewById(R.id.emailEditText);
        emailTextView.setText("Last Name:" + emailEditText.getText().toString());

/*
        if(txtHello.getText() == "Hello") {
            txtHello.setText("Not Hello");
        } else {
            txtHello.setText("Hello");
        }
        */

    }
}