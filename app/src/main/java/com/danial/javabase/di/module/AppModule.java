package com.danial.javabase.di.module;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.danial.javabase.data.remote.ApiConstants;
import com.danial.javabase.data.remote.ApiService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The application module which provides app wide instances of various components
 * Author: Daniyal Irfan
 * Email: daniyal@techbayportal.com
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        /* ConnectionSpec.MODERN_TLS is the default value */
        List tlsSpecs = Arrays.asList(ConnectionSpec.MODERN_TLS);

        /* providing backwards-compatibility for API lower than Lollipop: */
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            tlsSpecs = Arrays.asList(ConnectionSpec.COMPATIBLE_TLS);
        }


        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MINUTES);
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MINUTES);
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MINUTES);
        //  okHttpClient.addInterceptor(new RequestInterceptor());
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        okHttpClient.connectionSpecs(tlsSpecs);
        okHttpClient.connectionPool(new ConnectionPool(0, 5, TimeUnit.MINUTES));

        List my = new ArrayList();
        my.add(Protocol.HTTP_1_1);
        okHttpClient.protocols(my);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient,Context context) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiService.class);
    }


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
