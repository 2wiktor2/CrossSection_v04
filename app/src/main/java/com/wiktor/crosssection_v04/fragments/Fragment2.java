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

import com.wiktor.crosssection_v04.R;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Fragment2 extends Fragment implements View.OnClickListener {

private double diameter;
private double result;

Button buttonCalculate;
EditText inputDiameter;
TextView textViewResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        buttonCalculate = getActivity().findViewById(R.id.button_calculate_fragment_2);
        inputDiameter = getActivity().findViewById(R.id.edit_text_fragment_2);
        textViewResult = getActivity().findViewById(R.id.text_view3_fragment2);

        buttonCalculate.setOnClickListener(this);



    }

    public static Fragment2 newInstance() {
        Fragment2 fragment2 = new Fragment2();
        return fragment2;
    }

    private void raschetSechenya(){
  if (!inputDiameter.getText().toString().equals(""))
        diameter = Double.parseDouble(inputDiameter.getText().toString());
        result = diameter * diameter * 0.785;
    }

    @Override
    public void onClick(View v) {
        // todo не пашет тост
        //Toast.makeText(getContext(),Double.toString(result), Toast.LENGTH_SHORT).show();

        raschetSechenya();
        BigDecimal bd = new BigDecimal(result).setScale(3, RoundingMode.HALF_EVEN);
        result = bd.doubleValue();
        textViewResult.setText(Double.toString(result));

    }
}
