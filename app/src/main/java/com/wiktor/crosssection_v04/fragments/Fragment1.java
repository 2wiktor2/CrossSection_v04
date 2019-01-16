package com.wiktor.crosssection_v04.fragments;

import android.content.Context;
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

import com.wiktor.crosssection_v04.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Fragment1 extends Fragment implements View.OnClickListener {


    private Button buttonCalculate;
    private EditText inputDiameter;
    private EditText inputCount;
    private TextView textViewResult;

    Context context;


    double diameterFragment1 = 0;
    int countZH = 0;
    double result = 0;

    public static Fragment1 newInstance() {
        Fragment1 fragment1 = new Fragment1();
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonCalculate = getActivity().findViewById(R.id.button_calculate_fragment_1);
        inputDiameter = getActivity().findViewById(R.id.edit_text_fragment_1);
        inputCount = getActivity().findViewById(R.id.edit_text2_fragment_1);
        textViewResult = getActivity().findViewById(R.id.text_view3_fragment1);

        buttonCalculate.setOnClickListener(this);

        context = getContext();
    }

    private void raschetSecheniya() {
        if (!inputDiameter.getText().toString().equals("")) {
            diameterFragment1 = Double.parseDouble(inputDiameter.getText().toString());
        }
        if (!inputCount.getText().toString().equals(""))
        countZH = Integer.parseInt(inputCount.getText().toString());

        result = diameterFragment1 * diameterFragment1 * 0.785 * countZH;

    }

    void setResult() {
        BigDecimal bd = new BigDecimal(result).setScale(3, RoundingMode.HALF_EVEN);
        result = bd.doubleValue();
        textViewResult.setText(Double.toString(result));
    }

    @Override
    public void onClick(View v) {
        raschetSecheniya();
        setResult();
        //Toast.makeText(context, Double.toString(result), Toast.LENGTH_SHORT).show();


    }
}
