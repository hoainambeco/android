package com.example.asm.ui.thongke;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.asm.repository.ThuRepository;
import com.example.asm.repository.chiRepository;

public class ThongKeViewModel extends AndroidViewModel {
    private ThuRepository mThuRepository;
    private LiveData<Integer> mTongThu;

    private chiRepository mchChiRepository;
    private LiveData<Integer> mTongChi;

    public ThongKeViewModel(@NonNull Application application) {
        super(application);
        mThuRepository = new ThuRepository(application);
        mTongThu = mThuRepository.sumTongThu();

        mchChiRepository = new chiRepository(application);
        mTongChi = mchChiRepository.sumTongChi();

    }

    public LiveData<Integer> getTongThu() {
        return mTongThu;
    }

    public LiveData<Integer> getTongChi() {
        return mTongChi;
    }
}
