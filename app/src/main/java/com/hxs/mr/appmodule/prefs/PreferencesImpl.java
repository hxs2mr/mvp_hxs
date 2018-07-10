package com.hxs.mr.appmodule.prefs;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * **********************
 * 功 能:主题帮助类实现类

 * *********************
 */

public class PreferencesImpl implements PreferencesHelper {

    private static final String SHAREDPREFERENCES_NAME = "guizhou";
    private  SharedPreferences mSPrefs;

    @Inject
    public PreferencesImpl() {
      //  mSPrefs = getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }
    @Override
    public boolean getNightModeState() {
        return false;
    }

    @Override
    public void setNightModeState(boolean state) {

    }
}
