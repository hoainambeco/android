package com.example.asm.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.asm.entity.LoaiThu;
import com.example.asm.entity.Thu;
import com.example.asm.repository.LoaiThuRepository;
import com.example.asm.repository.ThuRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KhoanThuViewModel extends AndroidViewModel {
    private ThuRepository mThuRepository;
    private LoaiThuRepository mLoaiThuRepository;
    private LiveData<List<LoaiThu>> mAllLoaiThu;
    private LiveData<List<Thu>> mAllThu;
    public KhoanThuViewModel(@NonNull @NotNull Application application) {
        super(application);
        mThuRepository = new ThuRepository(application);
        mAllThu = mThuRepository.getAllThu();
        mLoaiThuRepository = new LoaiThuRepository(application);
        mAllLoaiThu = mLoaiThuRepository.getAllLoaiThu();
    }
    public LiveData<List<LoaiThu>> getAllLoaiThu(){
        return mAllLoaiThu;
    }
    public LiveData<List<Thu>> getmAllThu() {
        return mAllThu;
    }
    public void insert (Thu thu){
        mThuRepository.insert(thu);
    }
    public void delete(Thu thu){
        mThuRepository.delete(thu);
    }
    public void update(Thu thu){
        mThuRepository.update(thu);
    }
}