package com.example.android_task5;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class SettingDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_SETTING_OPTION = "option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_detail);

        String option = getIntent().getStringExtra(EXTRA_SETTING_OPTION);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (option == null) {
            finish();
            return;
        }

        switch (option) {
            case "network": {
                fragmentManager.beginTransaction()
                        .add(R.id.settingsContainer, new NetworkSettingsFragment())
                        .commit();
                break;
            }
            case "display": {
                fragmentManager.beginTransaction()
                        .add(R.id.settingsContainer, new DisplaySettingsFragment())
                        .commit();
                break;
            }
            case "storage": {
                fragmentManager.beginTransaction()
                        .add(R.id.settingsContainer, new StorageSettingsFragment())
                        .commit();
                break;
            }
        }
    }
}
