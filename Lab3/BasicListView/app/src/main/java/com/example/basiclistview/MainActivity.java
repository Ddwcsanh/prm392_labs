package com.example.basiclistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String[] DEFAULT_STRING = {"Android", "PHP", "iOS", "Unity", "ASP.net"};
    private int click = 0;

    ArrayList<List> list = new ArrayList<>();
    ListAdapter listAdapter;
    ListView listViewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        list.add(new List("Android"));
        list.add(new List("PHP"));
        list.add(new List("iOS"));
        list.add(new List("Unity"));
        list.add(new List("ASP.net"));

        listAdapter = new ListAdapter(list);

        listViewItem = findViewById(R.id.listItem);
        listViewItem.setAdapter(listAdapter);

        listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List list = (List) listAdapter.getItem(position);
                Toast.makeText(MainActivity.this, list.name, Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!list.isEmpty()) {
                    int item = 0;
                    list.remove(item);
                    listAdapter.notifyDataSetChanged();
                }
            }
        });

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String randomString = DEFAULT_STRING[click % 5];
                list.add(0, new List(randomString));
                click++;
                listAdapter.notifyDataSetChanged();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}