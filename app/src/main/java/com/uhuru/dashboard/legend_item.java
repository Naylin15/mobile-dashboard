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
 * Created by Thibaut on 15/01/16.
 */
public class legend_item {
    private int color;
    private String title;
    private int nb;

    public legend_item(int color, String title, int nb) {
        this.color = color;
        this.title = title;
        this.nb = nb;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}
