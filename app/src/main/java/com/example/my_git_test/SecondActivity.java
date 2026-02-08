package com.example.my_git_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getIntentInfo(); // Get intent info from MainActivity

        initMenu(); // Initialize menu items
    }

    private void getIntentInfo() {
        Intent intent = getIntent();
        intent.getExtras();
        String message = intent.getStringExtra("message");
        int number = intent.getIntExtra("number", 0);
        Toast.makeText(this, "message = " + message + "\nnumber = " + number, Toast.LENGTH_LONG).show();
    }
    private void initMenu() {
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
            if (id == R.id.item1) {
                Toast.makeText(this, "Item1 Clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.item2) {
                Toast.makeText(this, "Item2 Clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.item3) {
                Toast.makeText(this, "Item3 Clicked", Toast.LENGTH_SHORT).show();
            }
        return super.onOptionsItemSelected(item);
    }
}