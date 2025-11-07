package com.example.buixuanvan_recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView img = findViewById(R.id.img_chi_tiet);
        TextView tvTieuDe = findViewById(R.id.tv_tieu_de_chi_tiet);
        TextView tvMoTa = findViewById(R.id.tv_mo_ta_chi_tiet);

        String tieuDe = getIntent().getStringExtra("tieu_de");
        String moTa = getIntent().getStringExtra("mo_ta");
        int imgRes = getIntent().getIntExtra("img", R.drawable.ic_launcher_foreground);

        tvTieuDe.setText(tieuDe);
        tvMoTa.setText(moTa);
        img.setImageResource(imgRes);

        LinearLayout layoutQuayLai = findViewById(R.id.layout_quay_lai);
        layoutQuayLai.setOnClickListener(v -> finish());

    }
}
