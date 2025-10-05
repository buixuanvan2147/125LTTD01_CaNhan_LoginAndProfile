package com.example.loginandprofile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Ánh xạ nút đăng nhập
        Button btnLogin = findViewById(R.id.btnDangNhap_147);

        // Bắt sự kiện nhấn
        btnLogin.setOnClickListener(v -> {
            // Chuyển sang màn hình Profile
            Intent i = new Intent(MainActivity.this, Profile.class);
            startActivity(i);
        });

    }
}