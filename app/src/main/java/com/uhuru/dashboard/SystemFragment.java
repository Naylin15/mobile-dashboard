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
 * Created by Thibaut on 21/04/15.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SystemFragment extends Fragment {

    private String TAG = "Dashboard";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_system, container, false);
    }

    public void onResume(){
        Log.i(TAG, "onResume SYS");
        super.onResume();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Dashboard", "onActivityCreated SYS");
        SQLiteDatabaseHandler db = new SQLiteDatabaseHandler(getActivity());
        List<SaveData> showdata;// = new ArrayList<SaveData>();
        showdata = db.showAll();

        ListView lvMain = (ListView) getActivity().findViewById(R.id.listViewSys);

        List<cellule> tableau = new ArrayList<>();

        Calendar cal = Calendar.getInstance(Locale.getDefault());
        //list = new ArrayList<String>();

        for(SaveData save : showdata){
            if(save.getModule().equals("pm")) {
                cal.setTimeInMillis(Long.parseLong(save.getTimestamp()));
                String date = DateFormat.format("dd/MM/yyyy HH:mm:ss", cal).toString();
                tableau.add(0, new cellule(R.mipmap.notif_jaune, getString(R.string.app_blocked_msg) + save.getIncident() + getString(R.string.blocked_msg) , date));
            }
            if(save.getModule().equals("lib")) {
                cal.setTimeInMillis(Long.parseLong(save.getTimestamp()));
                String date = DateFormat.format("dd/MM/yyyy HH:mm:ss", cal).toString();
                tableau.add(0, new cellule(R.mipmap.notif_rouge, getString(R.string.lib_blocked_msg) + save.getIncident() + getString(R.string.blocked_msg) , date));
            }
            if(save.getModule().equals("execve")) {
                cal.setTimeInMillis(Long.parseLong(save.getTimestamp()));
                String date = DateFormat.format("dd/MM/yyyy HH:mm:ss", cal).toString();
                tableau.add(0, new cellule(R.mipmap.notif_rouge, getString(R.string.bin_blocked_msg) + save.getIncident() + getString(R.string.blocked_msg) , date));
            }
        }
        celluleAdapter adapter = new celluleAdapter(getActivity(), tableau);
        lvMain.setAdapter(adapter);
    }

}
