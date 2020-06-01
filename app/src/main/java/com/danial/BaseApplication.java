package com.danial;

import android.app.Application;

import com.danial.javabase.BuildConfig;
import com.danial.javabase.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import io.paperdb.Paper;
import timber.log.Timber;


public class BaseApplication extends Application implements HasAndroidInjector {

    private static BaseApplication sInstance;

    public static BaseApplication getAppContext() {
        return sInstance;
    }

    private static synchronized void setInstance(BaseApplication app) {
        sInstance = app;
    }

    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeComponent();
        Paper.init(this);
        setInstance(this);

        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }


    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }


    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingInjector;
    }


}
