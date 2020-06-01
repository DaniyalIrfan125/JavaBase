package com.danial.javabase.ui.fragments.homefragment;

import com.danial.javabase.data.remote.repository.MainRepository;
import com.danial.javabase.ui.base.BaseViewModel;

import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel {

    private MainRepository mainRepository;

    @Inject
    public HomeViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }
}
