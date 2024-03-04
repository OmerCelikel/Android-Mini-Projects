package com.celikel.testapp;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CheckApps {
    public static boolean isAppInstall(Context context, String paketAdi) {
        PackageManager packageManager = context.getPackageManager();
        try {
            // getApplicationInfo method shows app info
            packageManager.getApplicationInfo(paketAdi, 0);
            return true; //found the app
        } catch (PackageManager.NameNotFoundException e) {
            return false; // can not find the app
        }
    }

    public static void listInstalledApps(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        List<String> appNames = new ArrayList<>();
        List<ApplicationInfo> applicationInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
/*
        for (PackageInfo packageInfo : packages) {
            String appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            String packageName = packageInfo.packageName;
            Log.d("Installed App", "App Name: " + appName + ", Package Name: " + packageName);
            appNames.add(appName);
        }

 */

        for (ApplicationInfo applicationInfo : applicationInfoList) {
            Log.d("AppName =", "applicationInfo: " + applicationInfo);
        }
    }
}
