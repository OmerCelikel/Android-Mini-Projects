package com.celikel.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStatusOfApp();
    }

    private void checkStatusOfApp() {
        String targetAppName = "com.celikel.uninstalltracker";
        CheckApps.listInstalledApps(this);
        if (CheckApps.isAppInstall(this, targetAppName)) {
            Toast.makeText(MainActivity.this, (targetAppName + " found"), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, (targetAppName + " can not found"), Toast.LENGTH_SHORT).show();
        }
    }
}