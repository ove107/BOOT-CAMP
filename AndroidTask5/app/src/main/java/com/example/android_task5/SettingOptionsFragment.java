package com.example.android_task5;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingOptionsFragment extends Fragment {

    interface OnOptionClickListener {
        void onOptionSelected(String option);
    }

    private OnOptionClickListener mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnOptionClickListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement SettingOptionsFragment.OnOptionClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings_option_view, container, false);

        LinearLayout mNetworkOption = rootView.findViewById(R.id.networkOption);
        LinearLayout mStorageOption = rootView.findViewById(R.id.storageOption);
        LinearLayout mDisplayOption = rootView.findViewById(R.id.displayOption);

        mNetworkOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("network");
            }
        });

        mStorageOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("storage");
            }
        });

        mDisplayOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("display");
            }
        });

        return rootView;
    }
}
