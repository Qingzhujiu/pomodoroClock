package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment mCurrentFragment;
    private int mCurrentLayoutID;
    private Fragment mListFragment, mStatisticsFragment, mSettingFragment;
    private Bundle mListBundle, mStatisticsBundle, mSettingBundle;
    private RadioButton mListRButton, mStatisticsRButton, mSettingRButton;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        showFragment(mListFragment);
    }

    void init() {
        initButton();
        initFragment();
        initEvent();
    }

    void initButton() {
        mListRButton = findViewById(R.id.list_button);
        mStatisticsRButton = findViewById(R.id.statistics_button);
        mSettingRButton = findViewById(R.id.settings_button);
    }

    void initEvent() {
        mListRButton.setOnClickListener(this);
        mStatisticsRButton.setOnClickListener(this);
        mSettingRButton.setOnClickListener(this);
    }

    void initFragment() {
        mCurrentFragment = new Fragment();
        mFragmentManager = getSupportFragmentManager();
        //FragmentTransaction transaction = mFragmentManager.beginTransaction();

        mListFragment = new listFragment();
        mListBundle = new Bundle();
        mListFragment.setArguments(mListBundle);
        //transaction.add(R.id.list_fragment_container, mListFragment).commit();

        mStatisticsFragment = new statisticsFragment();
        mStatisticsBundle = new Bundle();
        mStatisticsFragment.setArguments(mStatisticsBundle);
        //transaction.add(R.id.settings_fragment_container, mSettingFragment).commit();

        mSettingFragment = new settingsFragment();
        mSettingBundle = new Bundle();
        mSettingFragment.setArguments(mSettingBundle);
        //transaction.add(R.id.statistics_fragment_container, mStatisticsFragment).commit();
    }

    void showFragment(Fragment fragment) {
        if (mCurrentFragment != fragment) {

            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.hide(mCurrentFragment);
            mCurrentFragment = fragment;
            if (!mCurrentFragment.isAdded()) {
                transaction.add(R.id.main_activity_container, mCurrentFragment);
            }
            transaction.show(mCurrentFragment).commit();
        }
    }

    @Override
    public void onClick(View view) {
        int selected = view.getId();
        switch (selected) {
            case R.id.list_button: {
                mCurrentLayoutID = R.id.list_fragment_container;
                showFragment(mListFragment);
                Log.d("Clicked", "list");
            }
            break;
            case R.id.statistics_button: {
                mCurrentLayoutID = R.id.statistics_fragment_container;
                showFragment(mStatisticsFragment);
                Log.d("Clicked", "statistics");
            }
            break;
            case R.id.settings_button: {
                mCurrentLayoutID = R.id.settings_fragment_container;
                showFragment(mSettingFragment);
                Log.d("Clicked", "setting");
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}


