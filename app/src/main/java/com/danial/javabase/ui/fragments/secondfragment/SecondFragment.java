package com.danial.javabase.ui.fragments.secondfragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danial.javabase.R;
import com.danial.javabase.data.local.SharedPreferenceProvider;
import com.danial.javabase.ui.base.BaseFragment;

public class SecondFragment extends BaseFragment {

    private SecondViewModel mViewModel;
    TextView tv;
    View mView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.second_fragment, container, false);

    initialising();
        return mView;
    }


    private void initialising() {
    tv = mView.findViewById(R.id.tv);

    tv.setText(new SharedPreferenceProvider(getContext()).getValue());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SecondViewModel.class);
        // TODO: Use the ViewModel
    }

}
