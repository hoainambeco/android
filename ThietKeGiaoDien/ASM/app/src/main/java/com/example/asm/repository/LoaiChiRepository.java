package com.example.asm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.asm.dao.AppDatabase;
import com.example.asm.dao.LoaiChiDao;
import com.example.asm.entity.LoaiChi;

import java.util.List;

public class LoaiChiRepository {
    private LoaiChiDao mloaiThuDao;
    private LiveData<List<LoaiChi>> mAllLoaiChi;

    public LoaiChiRepository(Application application) {
        this.mloaiThuDao = AppDatabase.getDatabase(application).loaiChiDao();
        mAllLoaiChi = mloaiThuDao.findAll();
    }

    public LiveData<List<LoaiChi>> getAllLoaiChi() {
        return mAllLoaiChi;
    }
    public void insert(LoaiChi loaiThu){
        new InsertAsyncTask(mloaiThuDao).execute(loaiThu);
    }
    public void delete(LoaiChi loaiThu){
        new DeleteAsyncTask(mloaiThuDao).execute(loaiThu);
    }
    public void update(LoaiChi loaiThu){
        new UpdateAsyncTask(mloaiThuDao).execute(loaiThu);
    }

    class InsertAsyncTask extends AsyncTask<LoaiChi, Void, Void>{
        private LoaiChiDao mLoaiChiDao;
        public InsertAsyncTask(LoaiChiDao loaiThuDao) {
            this.mLoaiChiDao= loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiThus) {
            mloaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<LoaiChi, Void, Void>{
        private LoaiChiDao mLoaiChiDao;
        public DeleteAsyncTask(LoaiChiDao loaiThuDao) {
            this.mLoaiChiDao= loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiThus) {
            mloaiThuDao.delete(loaiThus[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<LoaiChi, Void, Void>{
        private LoaiChiDao mLoaiChiDao;
        public UpdateAsyncTask(LoaiChiDao loaiThuDao) {
            this.mLoaiChiDao= loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiThus) {
            mloaiThuDao.update(loaiThus[0]);
            return null;
        }
    }
}
