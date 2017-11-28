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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PDFreport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreport);
        Bundle extras = getIntent().getExtras();
        //Log.i(TAG, "onStartCommand " + extras.getString("notif"));
        if (extras.containsKey("content")) {
            TextView report = (TextView) findViewById(R.id.report_text);
            report.setText(extras.getString("content"));
        }else {
            Log.i("PDF_report", "NO REPORT!");
        }
    }
}
