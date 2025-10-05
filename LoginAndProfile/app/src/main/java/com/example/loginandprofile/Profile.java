package com.example.loginandprofile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout layoutQuayLai = findViewById(R.id.layout_quay_lai);
        layoutQuayLai.setOnClickListener(v -> {
            finish(); // quay lại màn trước đó
        });

        // Ánh xạ nút logout
        Button btnLogout = findViewById(R.id.btnDangXuat_147);
        // Bắt sự kiện nhấn
        btnLogout.setOnClickListener(v -> {
            // Chuyển sang màn hình Profile
            Intent i = new Intent(Profile.this, MainActivity.class);
            startActivity(i);
        });


    }
}