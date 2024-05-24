package com.example.lab5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.adapters.UserAdapter;
import com.example.lab5.models.User;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ArrayList<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        RecyclerView rvUser = findViewById(R.id.rvUser);

        userList = new ArrayList<User>();
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));
        userList.add(new User("AnhLDD", "Le Do Duc Anh", "anhldd@fpt.edu.vn"));


        UserAdapter adapter = new UserAdapter(userList);

        rvUser.setAdapter(adapter);
        rvUser.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}