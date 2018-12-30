package com.wiktor.crosssection_v04.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wiktor.crosssection_v04.R;


public class Fragment3 extends Fragment implements View.OnClickListener {

    private EditText editTextLength;
    private EditText editTextTurns;
    private Button buttonCalculate;

    private TextView textViewResult;

    private double length;
    private double turns;
    private double result;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextLength = getActivity().findViewById(R.id.edit_text_fragment_3);
        editTextTurns = getActivity().findViewById(R.id.edit_text2_fragment_3);
        buttonCalculate = getActivity().findViewById(R.id.button_calculate_fragment_3);
        textViewResult = getActivity().findViewById(R.id.text_view3_fragment3);

        buttonCalculate.setOnClickListener(this);
    }

    private void calculations() {
        length = Double.parseDouble(editTextLength.getText().toString());
        turns = Double.parseDouble(editTextTurns.getText().toString());

        Double diam = length / turns;
        result = diam * diam * 0.785;
    }

    private void setResult() {
        textViewResult.setText(Double.toString(result));
    }

    public static Fragment3 newInstance() {
        Fragment3 fragment3 = new Fragment3();
        return fragment3;
    }

    @Override
    public void onClick(View v) {

        calculations();
        setResult();
        Toast.makeText(getContext(), Double.toString(result), Toast.LENGTH_SHORT).show();

    }
}
