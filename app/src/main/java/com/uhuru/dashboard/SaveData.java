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
 * Created by dorian on 14/04/15.
 */
public class SaveData {

    private int id;
    private String timestamp;
    private String module;
    private int verbose;
    private String incident;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getVerbose() {
        return verbose;
    }

    public void setVerbose(int verbose) {
        this.verbose = verbose;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    @Override
    public String toString() {
        return "SaveData [id=" + id + ", module=" + module + ", verbose=" + verbose
                + ", incident=" + incident + ", comment=" + comment + "]";
    }

    public SaveData(String timestamp, String module, int verbose, String incident) {
        super();
        //this.id = id;
        this.timestamp = timestamp;
        this.module = module;
        this.verbose = verbose;
        this.incident = incident;
        this.comment = null;
    }

    public SaveData(String timestamp, String module, int verbose, String incident, String comment) {
        super();
        //this.id = id;
        this.timestamp = timestamp;
        this.module = module;
        this.verbose = verbose;
        this.incident = incident;
        this.comment = comment;
    }

    public SaveData() {
        super();
        // TODO Auto-generated constructor stub
    }
}
