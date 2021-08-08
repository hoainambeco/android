package com.example.asm.ui.thongke;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.asm.R;

public class ThongKeFragment extends Fragment {

    private ThongKeViewModel mThongKeViewModel;
    private EditText metTongThu, metTongChi;

    public ThongKeFragment() {

    }

    public static ThongKeFragment newInstance() {
        ThongKeFragment fragment = new ThongKeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mThongKeViewModel = new ViewModelProvider(this).get(ThongKeViewModel.class);
        mThongKeViewModel.getTongThu().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer tong) {
                metTongThu.setText("" + tong);
            }
        });
        mThongKeViewModel.getTongChi().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                metTongChi.setText(""+integer);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_ke, container, false);
        metTongThu = view.findViewById(R.id.etTongThu);
        metTongChi = view.findViewById(R.id.etTongChi);
        return view;
    }
}