package com.danial.javabase.data.remote.repository;

import com.danial.javabase.data.remote.ApiService;

import javax.inject.Inject;

public class MainRepository {

    private ApiService apiService;

    @Inject
    MainRepository(ApiService service) {
        this.apiService = service;
    }


}
