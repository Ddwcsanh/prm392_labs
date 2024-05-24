package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    //Views
    private EditText edtSignUpUsn;
    private EditText edtSignUpPw;
    private EditText edtSignUpCfPw;
    private TextView tvAlreadyAcc;
    private Button btnSignUp;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Reference from layout
        edtSignUpUsn = findViewById(R.id.edtSignUpUsn);
        edtSignUpPw = findViewById(R.id.edtSignUpPw);
        edtSignUpCfPw = findViewById(R.id.edtSignUpCfPw);
        tvAlreadyAcc = findViewById(R.id.tvAlreadyAcc);
        btnSignUp = findViewById(R.id.btnSignUp);

        //Register event
        tvAlreadyAcc.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput() {
        //username
        if(TextUtils.isEmpty(edtSignUpUsn.getText().toString())) {
            edtSignUpUsn.setError(REQUIRE);
            return false;
        }

        //password
        if(TextUtils.isEmpty(edtSignUpPw.getText().toString())) {
            edtSignUpPw.setError(REQUIRE);
            return false;
        }

        //confirm password
        if(TextUtils.isEmpty(edtSignUpCfPw.getText().toString())) {
            edtSignUpCfPw.setError(REQUIRE);
            return false;
        }

        if(!TextUtils.equals(edtSignUpPw.getText().toString(), edtSignUpCfPw.getText().toString())) {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
            return false;
        }

        //valid
        return true;
    }

    private void signUp() {
        //invalid
        if(!checkInput()) {
            return;
        }
    }

    private void signInForm() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(R.id.btnSignUp == v.getId()) {
            signUp();
            return;
        }
        if(R.id.tvAlreadyAcc == v.getId()) {
            signInForm();
        }
    }
}
