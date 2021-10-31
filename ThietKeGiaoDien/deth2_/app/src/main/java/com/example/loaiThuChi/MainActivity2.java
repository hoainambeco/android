package com.example.loaiThuChi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.loaiThuChi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText ndtk;
    ImageButton tk;
    ImageButton them;

    DAOghichu daOghichu;
    ArrayList<Ghichu> ghichuArrayList;
    adapterGhichu adapterGhichu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView=findViewById(R.id.recycler);
        ndtk = findViewById(R.id.ndtk);
        tk = findViewById(R.id.tk);
        them = findViewById(R.id.them);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity2.this);
        recyclerView.setLayoutManager(layoutManager);
        daOghichu=new DAOghichu(MainActivity2.this);
        ghichuArrayList=new ArrayList<>();
        ghichuArrayList=daOghichu.getall();
        adapterGhichu=new adapterGhichu(MainActivity2.this,ghichuArrayList);
        recyclerView.setAdapter(adapterGhichu);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this , MainActivity3.class);
            /*    Bundle bundle2 = new Bundle();
                int a = -1;
                bundle2.putInt("Vitri2" , a);
                intent.putExtra("Data2" , bundle2);

             */
                startActivity(intent);
            }
        });

        tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ghichu> ht = new ArrayList<>();
                String title = ndtk.getText().toString();
                for(int i =0 ; i < daOghichu.getall().size() ; i++ ){
                    if(title.equals(daOghichu.getall().get(i).getTitle()) == true){
                        ht.add(daOghichu.getall().get(i));
                    }
                }
                if(ht.size() > 0) {
                    recyclerView.removeAllViews();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this);
                    recyclerView.setLayoutManager(layoutManager);
                    adapterGhichu = new adapterGhichu(MainActivity2.this, (ArrayList<Ghichu>) ht);
                    recyclerView.setAdapter(adapterGhichu);
                    ndtk.setText("");
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                    builder.setMessage("Không tìm thấy ghi chú");
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}