package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ActivityBai1 extends AppCompatActivity {
    String FileName = "MyFile.txt";
    EditText text;
    TextView lbltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        text = (EditText) findViewById(R.id.txtText);
        lbltext = (TextView) findViewById(R.id.lbltext);
    }
    public void DocFile(View view){
        try {
            FileInputStream fis = openFileInput(FileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            char[] inputBuffer = new char[1000000];
            String str = "";
            int charRead;
            while ((charRead = inputStreamReader.read(inputBuffer)) >0){
                String readstr = String.copyValueOf(inputBuffer,0,charRead);
                str = str + readstr;
            }
            lbltext.setText(str);
            Toast.makeText(this, "Đọc dữ liệu thành công", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("error: ", ex.toString());
            Toast.makeText(this, "Đọc dữ liệu thất bại", Toast.LENGTH_SHORT).show();
        }
    }
    public void GhiFile(View view){
        try {
            FileOutputStream fos = openFileOutput(FileName,MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(text.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, "Ghi dữ liệu thành công", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Log.e("error: ", ex.toString());
            Toast.makeText(this, "Ghi dữ liệu thất bại", Toast.LENGTH_SHORT).show();
        }
    }
}