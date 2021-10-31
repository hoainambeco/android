package com.example.myapplicationoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplicationoto.dao.OToDAO;
import com.example.myapplicationoto.dto.OTo;

import java.util.ArrayList;

public class ThongKeActivtity extends AppCompatActivity {

    Button btn_move_activity_ds, btn_move_activity_them;
    TextView tv_tong_oto, tv_tong_gia_tri_oto;
    Intent intent;

    ArrayList<OTo> arrOto;
    OToDAO oToDAO;
    int tong_gia_tri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_activtity);

        btn_move_activity_them = findViewById(R.id.btn_go_to_activity_them);
        btn_move_activity_ds = findViewById(R.id.btn_go_to_activity_danh_sach);

        tv_tong_oto = findViewById(R.id.tv_tong_oto);
        tv_tong_gia_tri_oto = findViewById(R.id.tv_tong_gia_tri_oto);


        btn_move_activity_ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ThongKeActivtity.this, DanhSachActivity.class);
                startActivity(intent);
            }
        });
        btn_move_activity_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ThongKeActivtity.this, ThemActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        oToDAO = new OToDAO(this);
        arrOto = oToDAO.danh_sach_oto();
        tong_gia_tri = 0;
        for (int i = 0; i < arrOto.size(); i++) {
            tong_gia_tri = tong_gia_tri + Integer.parseInt(arrOto.get(i).getGia_oto());
        }
        tv_tong_oto.setText(arrOto.size() + " oto");
        tv_tong_gia_tri_oto.setText(tong_gia_tri + " VNĐ");

//        tv_tong_oto.setText(arrOto.size() + " oto");
//        tv_tong_gia_tri_oto.setText(tong_gia_tri + " VNĐ");
    }
}