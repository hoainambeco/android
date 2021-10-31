package com.example.myapplicationoto;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationoto.dao.OToDAO;
import com.example.myapplicationoto.dto.OTo;
import com.google.android.material.snackbar.Snackbar;

public class ThemActivity extends AppCompatActivity {

    Button btn_huy_them, btn_them_oto;
    EditText ed_id_oto, ed_ma_oto, ed_gia_oto;
    OToDAO oToDAO;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        oToDAO = new OToDAO(this);
        btn_huy_them = findViewById(R.id.btn_huy_them_oto);
        btn_them_oto = findViewById(R.id.btn_them_oto);
        ed_id_oto = findViewById(R.id.ed_them_id_oto);
        ed_ma_oto = findViewById(R.id.ed_them_ma_oto);
        ed_gia_oto = findViewById(R.id.ed_them_gia_oto);

        View parentLayout = findViewById(android.R.id.content);
        btn_them_oto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed_id_oto.getText().length() == 0) {
                    Snackbar.make(parentLayout, "id dang trong", Snackbar.LENGTH_LONG)
                            .setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                            .show();
                    return;
                }

                if (ed_ma_oto.getText().length() == 0) {
                    Snackbar.make(parentLayout, "ma dang trong", Snackbar.LENGTH_LONG)
                            .setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                            .show();
                    return;
                }

                if (ed_gia_oto.getText().length() == 0) {
                    Snackbar.make(parentLayout, "gia dang trong", Snackbar.LENGTH_LONG)
                            .setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                            .show();
                    return;
                }

                OTo oTo = new OTo(ed_id_oto.getText().toString(),ed_ma_oto.getText().toString(), ed_gia_oto.getText().toString());
                long kq = oToDAO.them_oto(oTo);
                if (kq > 0) {
                    Snackbar.make(parentLayout, "Thêm thành công", Snackbar.LENGTH_LONG)
                            .setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                            .show();
                    ed_id_oto.setText("");
                    ed_ma_oto.setText("");
                    ed_gia_oto.setText("");
                }
                else {
                    Snackbar.make(parentLayout, "Thêm that bai", Snackbar.LENGTH_LONG)
                            .setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                            .show();
                }
            }
        });

    }
}