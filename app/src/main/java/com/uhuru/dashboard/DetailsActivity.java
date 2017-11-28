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

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;


public class DetailsActivity extends FragmentActivity implements
        ActionBar.TabListener {
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private String TAG = "Dashboard";
    // Tab titles
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        String[] tabs = { getString(R.string.system), getString(R.string.applications_tab), getString(R.string.stats) , getString(R.string.action_settings) };
        // Initialization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        //actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.setElevation(15);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
        onNewIntent(getIntent());

        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
                String ns = Context.NOTIFICATION_SERVICE;
                NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
                nMgr.cancel(position * 10 + 1);
                nMgr.cancel(position * 10 + 2);
                nMgr.cancel(position * 10 + 3);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        //Log.i("détails", "onTabSelected " + tab.getPosition());
        viewPager.setCurrentItem(tab.getPosition());
        /*String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
        nMgr.cancel(tab.getPosition() + 1);*/
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }




    public void onClick_app(View v){
        /*Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        Log.i("LogUhuru", ts + "#pm#0#message a afficher dans notification");*/
        Log.i("LogUhuru", "pm#0#com.groumf.root");
    }

    public void onClick_bin(View v){
        /*Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        Log.i("LogUhuru", ts + "#execve#0#message a afficher dans notification");*/
        Log.i("LogUhuru", "execve#0#evilExploit");
    }

    public void onClick_lib(View v){
        /*Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        Log.i("LogUhuru", ts + "#lib#0#message a afficher dans notification");*/
        Log.i("LogUhuru", "lib#0#libRoot_evil");
    }

    @Override
    public void onNewIntent(Intent intent){
        //Log.i(TAG, "onNewIntent début");
        startService(new Intent(DetailsActivity.this, LogReader.class));
        Bundle extras = getIntent().getExtras();
        int page;
        String from;
        if (extras != null)
        {
            page = extras.getInt("level");
            from = extras.getString("title");
            if (from.equals("notif")){
                actionBar.setSelectedNavigationItem(page);
                /*getIntent().removeExtra("level");
                getIntent().removeExtra("title");*/
                getIntent().putExtra("level", 0);
                getIntent().putExtra("title", "");
                //Log.i(TAG, "onCreate go to page " + page);
                String ns = Context.NOTIFICATION_SERVICE;
                NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
                nMgr.cancel(page * 10 + 1);
                nMgr.cancel(page * 10 + 2);
                nMgr.cancel(page * 10 + 3);
            }
        } else {
            //Log.i(TAG, "onCreate extra is null");
        }
    }



}