package com.toningethe.steppersampleapp;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;
import com.toningethe.steppersampleapp.fragments.FragmentFour;
import com.toningethe.steppersampleapp.fragments.FragmentOne;
import com.toningethe.steppersampleapp.fragments.FragmentThree;
import com.toningethe.steppersampleapp.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private static final String CURRENT_STEP_POSITION = "current_step";
    private StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepperLayout = findViewById(R.id.stepperLayout);

        int curr = 0;
        /* in case there is a saved instance */
        if (savedInstanceState != null) {
            curr = savedInstanceState.getInt(CURRENT_STEP_POSITION, 0);
        }
        stepperLayout.setAdapter(new MyStepperAdapter(getSupportFragmentManager(), this), curr);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_STEP_POSITION, stepperLayout.getCurrentStepPosition());
    }


    public static class MyStepperAdapter extends AbstractFragmentStepAdapter {

        private static final String CURRENT_STEP_POSITION_KEY = "to";

        public MyStepperAdapter(FragmentManager fm, Context context) {
            super(fm, context);
        }

        @Override
        public Step createStep(int position) {

            switch (position) {
                case 0:

                    FragmentOne step = new FragmentOne();
                    Bundle b = new Bundle();
                    b.putInt(CURRENT_STEP_POSITION_KEY, 0010000);
                    step.setArguments(b);
                    return step;

                case 1:

                    FragmentTwo two = new FragmentTwo();
                    Bundle qw = new Bundle();
                    qw.putInt(CURRENT_STEP_POSITION_KEY, 0020000);
                    two.setArguments(qw);
                    return two;

                case 2:
                    FragmentThree three = new FragmentThree();
                    Bundle pw = new Bundle();
                    pw.putInt(CURRENT_STEP_POSITION_KEY, 0030000);
                    three.setArguments(pw);
                    return three;


                case 3:

                    FragmentFour four = new FragmentFour();
                    Bundle fourBundle = new Bundle();
                    fourBundle.putInt(CURRENT_STEP_POSITION_KEY, 0030000);
                    four.setArguments(fourBundle);
                    return four;

                default:

                    FragmentOne one = new FragmentOne();
                    Bundle oneBundle = new Bundle();
                    oneBundle.putInt(CURRENT_STEP_POSITION_KEY, 0010000);
                    one.setArguments(oneBundle);
                    return one;


            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @NonNull
        @Override
        public StepViewModel getViewModel(@IntRange(from = 0) int position) {
            //Override this method to set Step title for the Tabs, not necessary for other stepper types
            StepViewModel.Builder spt = new StepViewModel.Builder(context);
            switch (position) {
                case 0:
                    return new StepViewModel.Builder(context)
                            .setTitle("Fragment One") //can be a CharSequence instead

                            .create();
                case 1:

                    return new StepViewModel.Builder(context)
                            .setTitle("Fragment Two") //can be a CharSequence instead
                            .create();

                case 2:

                    return new StepViewModel.Builder(context)
                            .setTitle("Fragment Three") //can be a CharSequence instead
                            .create();

                case 3:
                    return new StepViewModel.Builder(context)
                            .setTitle("Fragment Four") //can be a CharSequence instead
                            .create();

                default:

                    return new StepViewModel.Builder(context)
                            .setTitle("Fragment One") //can be a CharSequence instead
                            .create();
            }
        }

        private void addStepper(Fragment fm) {

        }
    }
}
