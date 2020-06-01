package com.danial.javabase.di.component;

import android.app.Application;

import com.danial.javabase.di.builder.ActivityBuilderModule;
import com.danial.javabase.di.module.AppModule;
import com.danial.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * The main application component which initializes all the dependent modules
 * Author: Daniyal
 * Email: daniyal@techbayportal.com
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(BaseApplication watyaApplication);
}