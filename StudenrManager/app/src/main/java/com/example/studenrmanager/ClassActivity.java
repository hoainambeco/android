package com.example.studenrmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studenrmanager.models.ClassDAO;
import com.example.studenrmanager.models.ClassManager;

public class ClassActivity extends AppCompatActivity {
    Button btnLuu,btnLamLai;
    EditText txtName,txtID;
    ListView lv;
    ClassDAO dao;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        txtID = (EditText) findViewById(R.id.txtID);
        txtName = (EditText) findViewById(R.id.txtName);
        btnLamLai = (Button) findViewById(R.id.btnLamLai);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        lv = (ListView) findViewById(R.id.lvClass);
        dao =new ClassDAO(ClassActivity.this);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,dao.getList());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassManager cls = dao.getList().get(position);
                txtID.setText(cls.getId());
                txtName.setText(cls.getName());
            }
        });
    }
    public void KhoiTaoUI(View view){
        txtID.setText("");
        txtName.setText("");
    }
    public void Them(View view){
        ClassManager cls = new ClassManager(txtID.getText().toString(),txtName.getText().toString());
        int kt = dao.add(cls);
        if (kt >0 ){
            Toast.makeText(getApplicationContext(),"Thêm mới thành công",Toast.LENGTH_LONG).show();
            adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,dao.getList());
            lv.setAdapter(adapter);
            this.KhoiTaoUI(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Thêm mới thất bại",Toast.LENGTH_LONG).show();
        }
    }
    public void update(View view){
        ClassManager cls = new ClassManager(txtID.getText().toString(),txtName.getText().toString());
        int kt = dao.update(cls);
        if (kt >=0){
            Toast.makeText(getApplicationContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
            adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,dao.getList());
            lv.setAdapter(adapter);
            this.KhoiTaoUI(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Sửa thất bại",Toast.LENGTH_LONG).show();
        }
    }
    public void Delete(View view){
        ClassManager cls = new ClassManager(txtID.getText().toString(),txtName.getText().toString());
        int kt = dao.delete(cls.getId());
        if (kt >=0){
            Toast.makeText(getApplicationContext(),"Xóa thành công",Toast.LENGTH_LONG).show();
            adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,dao.getList());
            lv.setAdapter(adapter);
            this.KhoiTaoUI(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Xóa thất bại",Toast.LENGTH_LONG).show();
        }
    }

}