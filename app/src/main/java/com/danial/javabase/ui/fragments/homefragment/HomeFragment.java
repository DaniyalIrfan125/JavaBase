package com.danial.javabase.ui.fragments.homefragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danial.javabase.R;
import com.danial.javabase.data.local.SharedPreferenceProvider;
import com.danial.javabase.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment {

    private HomeViewModel mViewModel;
    private View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_fragment, container, false);

        initialising();

        return mView;
    }

    private void initialising() {
        new SharedPreferenceProvider(getContext()).saveValue("daniyak");
        TextView tv_home = mView.findViewById(R.id.tv_home);
        tv_home.setOnClickListener(v ->
                Navigation.findNavController(tv_home).navigate(R.id.action_homeFragment_to_secondFragment));
    }


}
