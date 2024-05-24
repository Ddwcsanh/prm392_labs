package com.example.lab4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnFood.setOnClickListener(view -> {
            Intent intentFood = new Intent(MainActivity.this, FoodActivity.class);
            startActivity(intentFood);
        });

        binding.btnDrink.setOnClickListener(view -> {
            Intent intentDrink = new Intent(MainActivity.this, DrinkActivity.class);
            startActivity(intentDrink);
        });

        binding.btnExit.setOnClickListener(view -> {
            SharedPreferences myPref = getSharedPreferences("mySave", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = myPref.edit();
            myEdit.clear();
            myEdit.commit();
            binding.txtFood.setText("");
            binding.txtDrink.setText("");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences myPref = getSharedPreferences("mySave", MODE_PRIVATE);
        binding.txtFood.setText(myPref.getString("food", ""));
        binding.txtDrink.setText(myPref.getString("drink", ""));

    }

}