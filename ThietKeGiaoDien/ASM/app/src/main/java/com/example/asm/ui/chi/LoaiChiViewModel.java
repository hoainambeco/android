package com.example.asm.ui.chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.asm.entity.LoaiChi;
import com.example.asm.entity.LoaiThu;
import com.example.asm.repository.LoaiChiRepository;

import java.util.List;

public class LoaiChiViewModel extends AndroidViewModel {
    private LoaiChiRepository mLoaiChiRepository;
    private LiveData<List<LoaiChi>> mAllLoaiThu;
    public LoaiChiViewModel(@NonNull Application application) {
        super(application);
        mLoaiChiRepository = new LoaiChiRepository(application);
        mAllLoaiThu = mLoaiChiRepository.getAllLoaiChi();
    }

    public LiveData<List<LoaiChi>> getAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(LoaiChi loaiChi){
        mLoaiChiRepository.insert(loaiChi);
    }
    public void delete(LoaiChi loaiChi){
        mLoaiChiRepository.delete(loaiChi);
    }
    public void update(LoaiChi loaiChi){
        mLoaiChiRepository.update(loaiChi);
    }
}