package com.example.studenrmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studenrmanager.models.ClassDAO;
import com.example.studenrmanager.models.ClassManager;
import com.example.studenrmanager.models.Student;
import com.example.studenrmanager.models.StudentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentAtivity extends AppCompatActivity {
    Spinner spnClass;
    ArrayAdapter arrayAdapter;
    ClassDAO clsDAO;
    EditText txtSVBD,txtSVName;
    List<ClassManager> lsClass = new ArrayList<>();
    String strClass;
    StudentDAO stDAO;
    ListView lvStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_ativity);
        txtSVName = findViewById(R.id.txtSVName);
        txtSVBD = findViewById(R.id.txtSVBD);
        lvStudent = findViewById(R.id.lvStudent);
        spnClass = (Spinner) findViewById(R.id.spnClass);
        this.getClassRooms();
        spnClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strClass = lsClass.get(spnClass.getSelectedItemPosition()).getId();
                Toast.makeText(getApplicationContext(), strClass, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            });
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student st = stDAO.getlist().get(position);
                txtSVName.setText(st.getName());
                txtSVBD.setText(st.getNgaySinh());
            }
        });
    }

    public void save (View view){
        stDAO = new StudentDAO(StudentAtivity.this);
        Student st =new Student();
        st.setIdClass(strClass);
        st.setName(txtSVName.getText().toString());
        st.setNgaySinh(txtSVBD.getText().toString());
        try {
            if (stDAO.add(st) > 0){
                Toast.makeText(getApplicationContext(),"Thêm mới thành công",Toast.LENGTH_LONG).show();
                arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,stDAO.getlist());
                lvStudent.setAdapter(arrayAdapter);
            }
            else{
                Toast.makeText(getApplicationContext(),"Thêm mới thành công",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Lỗi",e.toString());
        }

    }
    public void KhoiTaoUI(View view){
        txtSVName.setText("");
        txtSVBD.setText("");
    }
    public void Sua(View view){
        Student st = new Student(txtSVName.getText().toString(),txtSVBD.getText().toString(),strClass);
        int kt = stDAO.update(st);
        if (kt >=0){
            Toast.makeText(getApplicationContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,stDAO.getlist());
            lvStudent.setAdapter(arrayAdapter);
            this.KhoiTaoUI(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Sửa thất bại",Toast.LENGTH_LONG).show();
        }
    }
    public void xoa(View view){
        Student st = new Student(txtSVName.getText().toString(),txtSVBD.getText().toString(),strClass);
        int kt = stDAO.delete(st.getNgaySinh());
        if (kt >=0){
            Toast.makeText(getApplicationContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,stDAO.getlist());
            lvStudent.setAdapter(arrayAdapter);
            this.KhoiTaoUI(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Xóa thất bại",Toast.LENGTH_LONG).show();
        }
    }
    public void getClassRooms(){
        clsDAO = new ClassDAO(StudentAtivity.this);
        lsClass = clsDAO.getList();
        arrayAdapter = new ArrayAdapter<ClassManager>(this, android.R.layout.simple_spinner_dropdown_item,clsDAO.getList());
        spnClass.setAdapter(arrayAdapter);
    }
}