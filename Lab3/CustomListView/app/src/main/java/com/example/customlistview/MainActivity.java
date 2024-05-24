package com.example.customlistview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.customlistview.adapters.FruitAdapter;
import com.example.customlistview.models.Fruits;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fruits> listFruits = new ArrayList<>();
    ListAdapter fruitAdapter;
    ListView listFruitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listFruits.add(new Fruits(1, "apple", "...some description goes here" , R.drawable.apple));
        listFruits.add(new Fruits(2, "banana", "...some description goes here", R.drawable.banana));
        listFruits.add(new Fruits(3, "blueberry", "...some description goes here", R.drawable.blueberries));
        listFruits.add(new Fruits(4, "corn", "...some description goes here", R.drawable.corn));
        listFruits.add(new Fruits(5, "grapes", "...some description goes here", R.drawable.grapes));

        fruitAdapter = new FruitAdapter( listFruits);
        listFruitView = findViewById(R.id.ctListView);
        listFruitView.setAdapter(fruitAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}