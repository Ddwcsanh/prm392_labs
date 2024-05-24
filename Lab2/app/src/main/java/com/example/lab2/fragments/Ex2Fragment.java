package com.example.lab2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ex2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ex2Fragment extends Fragment {

    private OnEx2FragmentListener mListener;

    public Ex2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex2, container, false);

        EditText firstNum = (EditText) view.findViewById(R.id.edtFirstNumber);
        EditText secondNum = (EditText) view.findViewById(R.id.edtSecondNumber);
        TextView txtOutput = (TextView) view.findViewById(R.id.txtOutputEx2);
        Button addBtn = (Button) view.findViewById(R.id.btnAdd);
        Button subBtn = (Button) view.findViewById(R.id.btnSub);
        Button mulBtn = (Button) view.findViewById(R.id.btnMul);
        Button divBtn = (Button) view.findViewById(R.id.btnDiv);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    if (firstNum.getText().toString().isEmpty() || secondNum.getText().toString().isEmpty()) {
                        txtOutput.setText("Please enter numbers");
                    } else {
                        float firstNumber = Float.parseFloat(firstNum.getText().toString());
                        float secondNumber = Float.parseFloat(secondNum.getText().toString());

                        float sum = firstNumber + secondNumber;
                        String output = String.valueOf(sum);
                        if (output.endsWith(".0")) {
                            output = output.substring(0, output.length() - 2);
                        }

                        txtOutput.setText(output);
                    }
                }
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    if (firstNum.getText().toString().isEmpty() || secondNum.getText().toString().isEmpty()) {
                        txtOutput.setText("Please enter numbers");
                    } else {
                        float firstNumber = Float.parseFloat(firstNum.getText().toString());
                        float secondNumber = Float.parseFloat(secondNum.getText().toString());

                        float sub = firstNumber - secondNumber;
                        String output = String.valueOf(sub);
                        if (output.endsWith(".0")) {
                            output = output.substring(0, output.length() - 2);
                        }

                        txtOutput.setText(output);
                    }
                }
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    if (firstNum.getText().toString().isEmpty() || secondNum.getText().toString().isEmpty()) {
                        txtOutput.setText("Please enter numbers");
                    } else {
                        float firstNumber = Float.parseFloat(firstNum.getText().toString());
                        float secondNumber = Float.parseFloat(secondNum.getText().toString());

                        float mul = firstNumber * secondNumber;
                        String output = String.valueOf(mul);
                        if (output.endsWith(".0")) {
                            output = output.substring(0, output.length() - 2);
                        }

                        txtOutput.setText(output);
                    }
                }
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    if (firstNum.getText().toString().isEmpty() || secondNum.getText().toString().isEmpty()) {
                        txtOutput.setText("Please enter numbers");
                    } else {
                        float firstNumber = Float.parseFloat(firstNum.getText().toString());
                        float secondNumber = Float.parseFloat(secondNum.getText().toString());

                        if (secondNumber == 0) {
                            txtOutput.setText("Cannot divide by zero");
                            return;
                        }

                        float div = firstNumber / secondNumber;
                        String output = String.valueOf(div);
                        if (output.endsWith(".0")) {
                            output = output.substring(0, output.length() - 2);
                        }

                        txtOutput.setText(output);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnEx2FragmentListener) {
            mListener = (OnEx2FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnEx2FragmentListener {

    }

    public boolean isValid(String firstNum, String secondNum) {
        if (firstNum.isEmpty() || secondNum.isEmpty()) {
            return false;
        }
        return true;
    }
}