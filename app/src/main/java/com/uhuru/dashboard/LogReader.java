/**
 * ----------------------------------------------------------------
 *  LICENSE
 *
 *  This file is part of the Uhuru Mobile Dashboard for Android,
 *  a subproject of Uhuru Mobile.
 *
 *  Uhuru Mobile is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 3
 *  of the License, or (at your option) any later version.
 *
 *  Uhuru Mobile is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  ----------------------------------------------------------------
 *  @copyright (C) 2017 Teclib' and contributors.
 *  @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 *  @link      https://github.com/uhuru-mobile/mobile-dashboard
 *  @link      http://www.uhuru-mobile.com/
 *  ----------------------------------------------------------------
 */

package com.uhuru.dashboard;

/**
 * Created by Thibaut on 14/01/16.
 */

import android.app.Service;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class LogReader extends Service {

    private static MyFileObserver fileObSDCARD;
    private static MyFileObserver fileObDOWNLOAD;

    private static Boolean isRunning = false;
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void onStart(Intent intent, int startId) {
        Log.i("Dashboard", "onStart service");

        fileObSDCARD = new MyFileObserver("/sdcard/");
        fileObDOWNLOAD = new MyFileObserver("/sdcard/Download");
        fileObSDCARD.startWatching();
        fileObDOWNLOAD.startWatching();

        try {
            /** On commence par flusher le logcat pour ne pas traiter les anciennes notifications */
            /*Process process =*/ Runtime.getRuntime().exec("logcat -c");
        } catch (IOException e){
            if(e!=null)
                e.printStackTrace();
        }
        if (!isRunning) {
            new Thread(new Runnable() {

                public void run() {
                    getLogs("logcat");
                }

            }).start();
            isRunning = true;
        } else{
            Log.i("Dashboard", "onStart service already running!");
        }
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public String getLogs(String cmd)
    {
        String logData = "";
        try
        {
            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));


            String line = "";
            Calendar date;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (line.contains("LogUhuru")) {
                    date = Calendar.getInstance();
                    Long tsLong = date.getTimeInMillis();
                    String ts = tsLong.toString();
                    String[] FirstSplit = line.split(":");
                    startService(new Intent(LogReader.this, UpdateWidgetService.class).putExtra("notif", ts + "#" + FirstSplit[1]).putExtra("from", 0));
                }
            }
        }
        catch (Exception e)
        {
            if(e!=null)
                Log.i("Dashboard", "getLogs CRASH!!");
                e.printStackTrace();
        }

        return logData;
    }

}