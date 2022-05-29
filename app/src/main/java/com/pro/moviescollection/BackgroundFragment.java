package com.pro.moviescollection;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.DialogFragment;

import com.pro.moviescollection.databinding.FragmentBackgroundDialogBinding;

public class BackgroundFragment extends DialogFragment {

    private FragmentBackgroundDialogBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_background_dialog, container, false);

        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        RadioGroup moodRadioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        TextView Theme = (TextView) rootView.findViewById(R.id.myTheme);


        moodRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // on radio button check change
                switch (checkedId) {
                    case R.id.radioButton1:
                        Theme.setText("Light Theme");
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    case R.id.radioButton2:
                        Theme.setText("Dark Theme");
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;

    }
}
