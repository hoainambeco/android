package com.example.lab41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lv;
    Button button;
    String Mang[] = new String[]{"ab","cd","de","ef"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_foreground);
        lv = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.item_layout,Mang);
        lv.setAdapter(arrayAdapter);
        registerForContextMenu(lv);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,button);
                popupMenu.getMenuInflater().inflate(R.menu.contextmenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId()==R.id.nhai)
                            Toast.makeText(MainActivity.this, "Nhai",Toast.LENGTH_SHORT).show();
                        if (item.getItemId()==R.id.cap)
                            Toast.makeText(MainActivity.this, "cap",Toast.LENGTH_SHORT).show();
                        if (item.getItemId()==R.id.Can)
                            Toast.makeText(MainActivity.this, "Can",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item1)
            Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.sub)
            Toast.makeText(this,"sub",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.one)
            Toast.makeText(this,"one",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.tow)
            Toast.makeText(this,"tow",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.ba)
            Toast.makeText(this,"ba",Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        if (item.getItemId()==R.id.nhai)
            Toast.makeText(this, "Nhai"+Mang[index],Toast.LENGTH_SHORT).show();
        if (item.getItemId()==R.id.cap)
            Toast.makeText(this, "cap"+Mang[index],Toast.LENGTH_SHORT).show();
        if (item.getItemId()==R.id.Can)
            Toast.makeText(this, "Can"+Mang[index],Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}