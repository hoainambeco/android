package com.example.lap5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> lsID =new ArrayList<>();
    List<Product> products = new ArrayList<>();
    EditText txtID,txtName,txtPrice,txtImage;
    Button btnThem,btnSua,btnHienthi,btnXoa;
    ProductDAO dal;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv);
        txtID=findViewById(R.id.txtID);
        txtName=findViewById(R.id.txtName);
        txtPrice=findViewById(R.id.txtPrice);
        txtImage=findViewById(R.id.txtImage);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnHienthi=findViewById(R.id.btnHienthi);
        btnXoa=findViewById(R.id.btnXoa);
        dal = new ProductDAO(MainActivity.this);
        products.add(new Product("01","Nam",5.5,Color.RED));
        products.add(new Product("02","Mẫn",5.5,Color.BLUE));
        products.add(new Product("03","Phong",5.5,Color.GREEN));

    }
    public void Them(View view) {
        Product product=new Product();
        product.setId(String.valueOf(txtID.getText()));
        product.setName(txtName.getText().toString());
        product.setImage(Integer.parseInt(txtImage.getText().toString()));
        product.setPrice(Double.parseDouble(String.valueOf(txtPrice.getText())));
        if(dal.insertProduct(product)<0)
        {
            Toast.makeText(this,"Them that bai",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Them thanh cong",Toast.LENGTH_LONG).show();
        }
    }

    public void Hienthi(View view) {
        lsID=dal.getAllMalop();

        adapter =new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,lsID);
        listView.setAdapter(adapter);

    }

    public void SUA(View view) {
        Product product =new Product();
        product.setId(String.valueOf(txtID.getText()));
        product.setName(txtName.getText().toString());
        product.setImage(Integer.parseInt(txtImage.getText().toString()));
        product.setPrice(Double.parseDouble(String.valueOf(txtPrice.getText())));

        int kq=dal.updateProduct(product);
        if(kq<=0)
        {
            Toast.makeText(getApplicationContext(),"Sua that bai",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Sua thanh cong",Toast.LENGTH_LONG).show();
        }

    }

    public void Xoa(View view) {
        Product product =new Product();
        product.setId(String.valueOf(txtID.getText()));
        product.setName(txtName.getText().toString());
        product.setPrice(Double.parseDouble(String.valueOf(txtPrice.getText())));
        product.setImage(Integer.parseInt(txtImage.getText().toString()));

        int kq=dal.deleteProduct(product.getId());
        if(kq<=0)
        {
            Toast.makeText(getApplicationContext(),"Xoa that bai",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Xoa thanh cong",Toast.LENGTH_LONG).show();
        }

    }
}