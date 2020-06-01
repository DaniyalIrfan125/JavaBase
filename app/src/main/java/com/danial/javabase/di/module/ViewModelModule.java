package com.danial.javabase.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.danial.javabase.ui.fragments.homefragment.HomeViewModel;
import com.danial.javabase.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Allows us to inject dependencies via constructor injection
 * Author: Daniyal irfan
 * Email: daniyal@techbayportal.com
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsHomeViewModel(HomeViewModel homeViewModel);

    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
