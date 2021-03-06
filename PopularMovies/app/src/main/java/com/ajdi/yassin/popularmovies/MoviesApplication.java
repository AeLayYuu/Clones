package com.ajdi.yassin.popularmovies;

import android.app.Application;

import androidx.databinding.library.baseAdapters.BuildConfig;

import timber.log.Timber;

/**
 * @author Yassin Ajdi
 * @since 11/10/2018.
 */
public class MoviesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
