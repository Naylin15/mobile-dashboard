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
 * Created by Thibaut on 20/01/16.
 *
 * La classe Grid permet de sauvegarder la fenêtre d'affichage d'un GraphicItem de type TYPE_LINE
 *
 */
public class Grid {
    private float minimumX, maximumX, minimumY, maximumY;

    public Grid() {
    }

    public float getMinimumX() {
        return minimumX;
    }

    public void setMinimumX(float minimumX) {
        this.minimumX = minimumX;
    }

    public float getMaximumX() {
        return maximumX;
    }

    public void setMaximumX(float maximumX) {
        this.maximumX = maximumX;
    }

    public float getMinimumY() {
        return minimumY;
    }

    public void setMinimumY(float minimumY) {
        this.minimumY = minimumY;
    }

    public float getMaximumY() {
        return maximumY;
    }

    public void setMaximumY(float maximumY) {
        this.maximumY = maximumY;
    }
}
