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
public class PieChartItem {
    private double value;
    private int color;
    private int stroke_color;
    private String legend;

    public PieChartItem(double value, int color, int stroke_color, String legend) {
        this.value = value;
        this.color = color;
        this.stroke_color = stroke_color;
        this.legend = legend;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getStrokeColor() {
        return stroke_color;
    }
    public void setStrokeColor(int color) {
        this.stroke_color = color;
    }
    public String getLegend(){
        return this.legend;
    }
    public void setLegend(String legend){
        this.legend = legend;
    }
}