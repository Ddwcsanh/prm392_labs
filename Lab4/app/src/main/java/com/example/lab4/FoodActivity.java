package com.example.lab4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4.databinding.ActivityFoodBinding;

public class FoodActivity extends AppCompatActivity {

    private ActivityFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);

        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences myPref = getSharedPreferences("mySave", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPref.edit();

        binding.btnOrderFood.setOnClickListener(view -> {
            RadioButton selectedRadioBtn = findViewById(binding.rgFood.getCheckedRadioButtonId());
            if (selectedRadioBtn == null) {
                binding.txtErrorFood.setText("Phải chọn 1 món ăn");
                return;
            }

            String food = selectedRadioBtn.getText().toString();

            myEdit.putString("food", food);
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