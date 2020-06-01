package com.danial.javabase.data.remote;

import androidx.annotation.NonNull;

import io.reactivex.annotations.Nullable;

import static com.danial.javabase.data.remote.Status.ERROR;
import static com.danial.javabase.data.remote.Status.LOADING;
import static com.danial.javabase.data.remote.Status.SUCCESS;

public class ApiResponse {

    public final Status status;

    @Nullable
    public final Object data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable Object data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull Object data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }

}