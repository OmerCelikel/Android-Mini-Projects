package com.celikel.uninstalltracker;

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

            if ("com.celikel.testapp".equals(packageName)) {
                Toast.makeText(context, "Done with pre-uninstallation tasks... Exiting Now", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

/*

@Override
    public void onReceive(Context context, Intent intent) {
        String[] packageNames = intent.getStringArrayExtra("android.intent.extra.PACKAGES");

        if (packageNames != null) {
            for (String packageName : packageNames) {
                if (packageName != null && packageName.equals("com.teb")) {
                    // User has selected our application under the Manage Apps settings
                    // now initiating background thread to watch for activity
                    new ListenActivities(context).start();
                }
            }
        }
    }
 */

class ListenActivities extends Thread {
    boolean exit = false;
    UsageStatsManager usageStatsManager;
    Context context;

    public ListenActivities(Context con) {
        context = con;
        usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
    }

    public void run() {
        Looper.prepare();

        while (!exit) {

            long currentTime = System.currentTimeMillis();
            List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_BEST, currentTime - 10000, currentTime);

            if (usageStatsList != null && !usageStatsList.isEmpty()) {
                String topActivity = usageStatsList.get(0).getPackageName();
                Log.d("topActivity", "CURRENT Activity ::" + topActivity);

                if (topActivity.equals("com.android.packageinstaller")) {
                    // User has clicked on the Uninstall button under the Manage Apps settings
                    // do whatever pre-uninstallation task you want to perform here
                    // show dialogue or start another activity or database operations etc..etc..
                    exit = true;
                    Toast.makeText(context, "Done with pre-uninstallation tasks... Exiting Now", Toast.LENGTH_SHORT).show();
                } else if (topActivity.equals("com.android.settings")) {
                    // back button was pressed and the user has been taken back to Manage Applications window
                    // we should close the activity monitoring now
                    exit = true;
                }
            }
        }
        Looper.loop();
    }
}
