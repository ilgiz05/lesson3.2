package com.example.lesson32.data.local;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesHelper {

    private final SharedPreferences sharedPreferences;

    @Inject
    PreferencesHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean getBoolean() {
        boolean isShown = sharedPreferences.getBoolean("shared_prefs", false);
        return isShown;
    }

    public void setBoolean(boolean isShown) {
        sharedPreferences.edit().putBoolean("shared_prefs", isShown).apply();
    }
}
