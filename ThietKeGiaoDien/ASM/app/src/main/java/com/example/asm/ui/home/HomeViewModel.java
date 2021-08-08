package com.example.asm.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chào mừng đến với chương trình quản lý thu chi của tôi!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}