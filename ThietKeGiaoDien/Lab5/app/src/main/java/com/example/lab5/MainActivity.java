package com.example.lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_foreground);

    }

    public void DatePicker(View view) {
        Calendar calendar  = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, year +" / " + (month+1)+" / "+ dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        },year,month,day);
        datePickerDialog.show();
    }

    public void TimePickerDialog(View view) {
        Calendar calendar  = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
            }
        },hour,minute,true);
        timePickerDialog.show();
    }
    public void LoadingDialog(View view) {

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        CountDownTimer countDownTimer = new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressDialog.setMessage("Loading.....");
                progressDialog.show();
            }

            @Override
            public void onFinish() {
                this.cancel();
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"done!",Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
//bài 3

    String cauTraLoi[] = {"red","green","blue","black"};
    public void SimpleDialog(View view) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tiêu đề");
        builder.setMessage("Đây là nội dung");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"bấm nút OK",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Canel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"bấm nút Canel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void ListDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Chọn màu");
        builder.setItems(cauTraLoi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, cauTraLoi[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void SingleChoiceDialog(View view) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tiêu đề");
        builder.setSingleChoiceItems(cauTraLoi, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, cauTraLoi[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void MultiChoiceDialog(View view) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tiêu đề");
        // 0 là vị trị mặc định đc chọn,
        builder.setMultiChoiceItems(cauTraLoi, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this,cauTraLoi[which]+ " "+ isChecked,Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void Login(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater layoutInflater= MainActivity.this.getLayoutInflater();
        View v=layoutInflater.inflate(R.layout.activity_login,null);
        builder.setView(v);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Canel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Hủy đăng nhập thành công",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

    }
}