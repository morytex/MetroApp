package br.com.moryta.metroapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by moryta on 26/06/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }
}
