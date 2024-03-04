package com.celikel.uninstalltracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.infoText)
    TextView infoText;

    @BindView(R.id.buttonCheckApps)
    Button buttonCheckApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        buttonCheckApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkStatusOfApp();
            }
        });


    }

    private void checkStatusOfApp() {
        String targetAppName = "com.teb.test";
        CheckApps.listInstalledApps(this);
        if (CheckApps.isAppInstall(this, targetAppName)) {
            Toast.makeText(MainActivity.this, (targetAppName + " found"), Toast.LENGTH_SHORT).show();
            infoText.setText("INFO: " + (targetAppName + " found"));
        } else {
            Toast.makeText(MainActivity.this, (targetAppName + " can not found"), Toast.LENGTH_SHORT).show();
            infoText.setText("INFO: " + (targetAppName + " can not found"));
        }
    }
}



        /*
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TAG", "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        String msg = token;
                        Log.d("msg", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

         */