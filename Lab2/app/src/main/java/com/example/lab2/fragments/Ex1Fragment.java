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

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ex1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ex1Fragment extends Fragment {
    private OnEx1FragmentListener mListener;

    public Ex1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ex1, container, false);

        Button btnGenerate = (Button) view.findViewById(R.id.btnGenerate);
        TextView txtOutput = (TextView) view.findViewById(R.id.txtOutputEx1);
        EditText edtMin = (EditText) view.findViewById(R.id.edtMin);
        EditText edtMax = (EditText) view.findViewById(R.id.edtMax);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    Random random = new Random();
                    int min = Integer.parseInt(edtMin.getText().toString());
                    int max = Integer.parseInt(edtMax.getText().toString());

                    if (max <= min) {
                        txtOutput.setText("Max must be greater than Min");
                    } else {
                        int randomNumber = random.nextInt(max - min) + min;
                        txtOutput.setText(String.valueOf(randomNumber));
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnEx1FragmentListener) {
            mListener = (OnEx1FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnEx1FragmentListener {

    }
}