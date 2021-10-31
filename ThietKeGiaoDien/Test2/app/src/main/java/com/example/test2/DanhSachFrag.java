package com.example.test2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DanhSachFrag extends Fragment {
    RecyclerView recyclerView;
    DanhSachAdapter danhSachAdapter;
    TestContronl sachControl;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_danh_sach_frag,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);

        sachControl = new TestContronl(getContext());
        danhSachAdapter = new DanhSachAdapter(getContext(), sachControl.Select());
        recyclerView.setAdapter(danhSachAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext() , RecyclerView.VERTICAL , false);
        recyclerView.setLayoutManager(layoutManager);

    }
}