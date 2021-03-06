package com.example.asm.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.asm.entity.LoaiThu;
import com.example.asm.repository.LoaiThuRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LoaiThuViewModel extends AndroidViewModel {
    private LoaiThuRepository mLoaiThuRepository;
    private LiveData<List<LoaiThu>> mAllLoaiThu;
    public LoaiThuViewModel(@NonNull @NotNull Application application) {
        super(application);
        mLoaiThuRepository = new LoaiThuRepository(application);
        mAllLoaiThu = mLoaiThuRepository.getAllLoaiThu();
    }

    public LiveData<List<LoaiThu>> getmAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert (LoaiThu loaiThu){
        mLoaiThuRepository.insert(loaiThu);
    }
    public void delete(LoaiThu loaiThu){
        mLoaiThuRepository.delete(loaiThu);
    }
    public void update(LoaiThu loaiThu){
        mLoaiThuRepository.update(loaiThu);
    }
}