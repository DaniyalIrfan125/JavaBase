package com.danial.javabase.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceProvider {

    private Context mContext;

    public SharedPreferenceProvider(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getPreferenceProvider() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void saveValue(String value) {
        getPreferenceProvider().edit().putString("value", value).apply();
    }

    public String getValue() {
        return getPreferenceProvider().getString("value", "yes oye");
    }

}
