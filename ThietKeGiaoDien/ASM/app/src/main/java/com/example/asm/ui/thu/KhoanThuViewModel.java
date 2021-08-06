package com.example.asm.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.asm.entity.Thu;
import com.example.asm.entity.Thu;
import com.example.asm.repository.ThuRepository;
import com.example.asm.repository.ThuRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KhoanThuViewModel extends AndroidViewModel {
    private ThuRepository mThuRepository;
    private LiveData<List<Thu>> mAllThu;
    public KhoanThuViewModel(@NonNull @NotNull Application application) {
        super(application);
        mThuRepository = new ThuRepository(application);
        mAllThu = mThuRepository.getAllThu();
    }

    public LiveData<List<Thu>> getmAllThu() {
        return mAllThu;
    }
    public void insert (Thu thu){
        mThuRepository.insert(thu);
    }
    // TODO: Implement the ViewModel
    public void delete(Thu thu){
        mThuRepository.delete(thu);
    }
    public void update(Thu thu){
        mThuRepository.update(thu);
    }
}