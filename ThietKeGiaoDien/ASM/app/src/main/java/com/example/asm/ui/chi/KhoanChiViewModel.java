package com.example.asm.ui.chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.asm.entity.Chi;
import com.example.asm.entity.LoaiChi;
import com.example.asm.entity.LoaiThu;
import com.example.asm.entity.Thu;
import com.example.asm.repository.LoaiChiRepository;
import com.example.asm.repository.chiRepository;


import java.util.List;


public class KhoanChiViewModel extends AndroidViewModel {
    private chiRepository mChiRepository;
    private LoaiChiRepository mLoaiChiRepository;
    private LiveData<List<LoaiChi>> mAllLoaiChi;
    private LiveData<List<Chi>> mAllChi;
    public KhoanChiViewModel(@NonNull Application application) {
        super(application);
        mChiRepository = new chiRepository(application);
        mAllChi = mChiRepository.getAllChi();
        mLoaiChiRepository = new LoaiChiRepository(application);
        mAllLoaiChi = mLoaiChiRepository.getAllLoaiChi();
    }

    public LiveData<List<LoaiChi>> getAllLoaiChi(){
        return mAllLoaiChi;
    }
    public LiveData<List<Chi>> getmAllLChi() {
        return mAllChi;
    }
    public void insert(Chi loaiChi){
        mChiRepository.insert(loaiChi);
    }
    public void delete(Chi loaiChi){
        mChiRepository.delete(loaiChi);
    }
    public void update(Chi loaiChi){
        mChiRepository.update(loaiChi);
    }
}