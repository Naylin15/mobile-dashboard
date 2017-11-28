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

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Thibaut on 15/01/16.
 */
public class celluleAdapter extends ArrayAdapter<cellule> {

    private List<cellule> cellules;
    //tweets est la liste des models à afficher
    public celluleAdapter(Context context, List<cellule> cells) {
        super(context, 0, cells);
        this.cellules = cells;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_cell,parent, false);
        }

        celluleViewHolder viewHolder = (celluleViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new celluleViewHolder();
            viewHolder.msg = (TextView) convertView.findViewById(R.id.msg);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<cellule> cell
        cellule cell = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.msg.setText(cell.getMsg());
        viewHolder.date.setText(cell.getDate());
        viewHolder.icon.setBackgroundResource(cell.getIcon());

        return convertView;
    }

    public cellule getItem(int position){

        return cellules.get(position);
    }

    private class celluleViewHolder{
        public TextView msg;
        public TextView date;
        public ImageView icon;
    }
}