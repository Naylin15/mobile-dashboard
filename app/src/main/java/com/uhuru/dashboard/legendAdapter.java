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
public class legendAdapter extends ArrayAdapter<legend_item> {

    //tweets est la liste des models à afficher
    public legendAdapter(Context context, List<legend_item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_legend,parent, false);
        }

        legendViewHolder viewHolder = (legendViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new legendViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.legend_title);
            viewHolder.nb = (TextView) convertView.findViewById(R.id.legend_nb);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<cellule> cell
        legend_item cell = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.title.setText(cell.getTitle());
        viewHolder.nb.setText("" + cell.getNb());
        viewHolder.nb.setTextColor(cell.getColor());

        return convertView;
    }

    private class legendViewHolder{
        public TextView title;
        public TextView nb;
    }
}