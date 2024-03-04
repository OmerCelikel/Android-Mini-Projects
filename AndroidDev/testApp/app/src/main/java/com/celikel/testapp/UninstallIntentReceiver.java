package com.celikel.testapp;
import android.content.BroadcastReceiver;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class UninstallIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)) {
            String packageName = intent.getData().getEncodedSchemeSpecificPart();
            Log.d("Uninstall", "Package removed: " + packageName);

            if ("com.celikel.uninstalltracker".equals(packageName)) {
                Toast.makeText(context, "Done with pre-uninstallation tasks... Exiting Now", Toast.LENGTH_SHORT).show();
            }
        }
    }
}