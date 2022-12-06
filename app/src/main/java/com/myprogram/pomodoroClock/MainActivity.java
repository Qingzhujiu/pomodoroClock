package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.myprogram.pomodoroClock.Pomodoro.Pomodoro;
import com.myprogram.pomodoroClock.Pomodoro.PomodoroViewModel;
import com.myprogram.pomodoroClock.Record.RecordDialog;
import com.myprogram.pomodoroClock.fragment.listFragment;
import com.myprogram.pomodoroClock.fragment.statisticsFragment;
import com.myprogram.pomodoroClock.fragment.tomatoClockFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RecordDialog.RecordDialogListener {
    private Fragment mCurrentFragment;
    private Fragment mListFragment, mStatisticsFragment, mSettingFragment, mTomatoClockFragment;
    private Bundle mListBundle, mStatisticsBundle, mSettingBundle, mTomatoClockBundle;
    private RadioButton mListRButton, mStatisticsRButton, mSettingRButton, mTomatoClockButton;
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
        /*
        mSettingRButton = findViewById(R.id.settings_button);

         */
        mTomatoClockButton = findViewById(R.id.tomato_clock_button);
    }

    void initEvent() {
        mListRButton.setOnClickListener(this);
        mStatisticsRButton.setOnClickListener(this);
        /*
        mSettingRButton.setOnClickListener(this);
         */
        mTomatoClockButton.setOnClickListener(this);
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
        /*
        mSettingFragment = new settingsFragment();
        mSettingBundle = new Bundle();
        mSettingFragment.setArguments(mSettingBundle);
        //transaction.add(R.id.statistics_fragment_container, mStatisticsFragment).commit();
         */
        mTomatoClockFragment = new tomatoClockFragment();
        mTomatoClockBundle = new Bundle();
        mTomatoClockFragment.setArguments(mTomatoClockBundle);

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
                showFragment(mListFragment);
                Log.d("Clicked", "list");
            }
            break;
            case R.id.statistics_button: {
                showFragment(mStatisticsFragment);
                Log.d("Clicked", "statistics");
            }
            break;
            /*
            case R.id.settings_button: {
                showFragment(mSettingFragment);
                Log.d("Clicked", "setting");
            }
            break;

             */
            case R.id.tomato_clock_button: {
                showFragment(mTomatoClockFragment);
                Log.d("Clicked", "tomatoClock");
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @Override
    public void onDialogPositiveClick(RecordDialog dialog) {
        statisticsFragment fragment = (statisticsFragment) mStatisticsFragment;
        fragment.RecordDelete(dialog.getRecord());
    }

    @Override
    public void onDialogNegativeClick(RecordDialog dialog) {
    }

}


