package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Magnifier;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Scanner;

public class ActivityBai2 extends AppCompatActivity {
    EditText text;
    TextView lbltext;
    String fileName ="MyFile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        text = (EditText) findViewById(R.id.txtText);
        lbltext = (TextView) findViewById(R.id.lbltext);
    }
    public void ReadFile(View view){
        StringBuffer stringBuffer = new StringBuffer();
        String aDateRow = "";
        String aBuffer = "";
        try {
            File file = new File("/sdcard/"+fileName);
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((aDateRow = reader.readLine()) != null){
                aBuffer = aDateRow + aBuffer;
            }
            lbltext.setText(aBuffer+"");
            reader.close();
            Toast.makeText(this, "Đọc file thành công", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Đọc file thất bại", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Đọc file thất bại", Toast.LENGTH_SHORT).show();
        }

        /*
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            String sdCradFile = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/sdcard/File.txt";
            try {
                Scanner scan = new Scanner(new FileInputStream(sdCradFile));
                String data ="";
                while (scan.hasNext()){
                    data += scan.nextLine()+"\n";
                }
                scan.close();
                lbltext.setText(data+"");
                Toast.makeText(this, "Đọc file thành công", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Đọc file thất bại", Toast.LENGTH_SHORT).show();
            }
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},999);
        }

         */
    }
    public void WriteFile(View view){
        FileOutputStream fos;
        try {
            File file = new File("/sdcard/"+ fileName);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(text.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();
            Toast.makeText(this, "Ghi file thành công", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ghi file thất bại", Toast.LENGTH_SHORT).show();
        }
        /*
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            String sdCradFile = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/sdcard/File.txt";
            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdCradFile));
                writer.write(text.getText().toString());
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Ghi file thất bại", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Ghi file thất bại", Toast.LENGTH_SHORT).show();
            }
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},999);
        }

         */
    }
}