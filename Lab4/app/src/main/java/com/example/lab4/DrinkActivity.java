package com.example.lab4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4.databinding.ActivityDrinkBinding;

public class DrinkActivity extends AppCompatActivity {

    private ActivityDrinkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drink);

        binding = ActivityDrinkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences myPref = getSharedPreferences("mySave", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPref.edit();

        binding.btnOrderDrink.setOnClickListener(view -> {
            RadioButton selectedRadioBtn = findViewById(binding.rgDrink.getCheckedRadioButtonId());
            if (selectedRadioBtn == null) {
                binding.txtErrorDrink.setText("Phải chọn 1 đồ uống");
                return;
            }

            String drink = selectedRadioBtn.getText().toString();

            myEdit.putString("drink", drink);
            myEdit.commit();
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}