package com.danial.javabase.di.builder;


import com.danial.javabase.ui.fragments.homefragment.HomeFragment;
import com.danial.javabase.ui.fragments.secondfragment.SecondFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This builder provides android injector service to fragments
 * Author: Daniyal
 * Email: daniyal@techbayportal.com
 */

@Module
public abstract class FragmentBuilderModule {


    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract HomeFragment contributeHomeFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract SecondFragment contributeSecondFragment();

}
