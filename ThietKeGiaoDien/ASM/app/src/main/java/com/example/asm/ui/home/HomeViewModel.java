package com.example.asm.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chào mừng đến với chương trình quản lý thu chi!\n" +
                "Người Phát Triển: Nguyễn Hoài Nam\n" +
                "Mã sinh viên: PH14161\n" +
                "Email: namnhph14161@fpt.edu.vn");
    }

    public LiveData<String> getText() {
        return mText;
    }
}