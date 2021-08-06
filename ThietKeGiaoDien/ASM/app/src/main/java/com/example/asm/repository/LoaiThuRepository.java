package com.example.asm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.asm.dao.AppDatabase;
import com.example.asm.dao.LoaiThuDao;
import com.example.asm.entity.LoaiThu;

import java.util.List;

public class LoaiThuRepository {
    private LoaiThuDao mloaiThuDao;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuRepository(Application application) {
        this.mloaiThuDao = AppDatabase.getDatabase(application).loaiThuDao();
        mAllLoaiThu = mloaiThuDao.findAll();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu){
        new InsertAsyncTask(mloaiThuDao).execute(loaiThu);
    }
    public void delete(LoaiThu loaiThu){
        new DeleteAsyncTask(mloaiThuDao).execute(loaiThu);
    }
    public void update(LoaiThu loaiThu){
        new UpdateAsyncTask(mloaiThuDao).execute(loaiThu);
    }

    class InsertAsyncTask extends AsyncTask<LoaiThu, Void, Void>{
        private LoaiThuDao mLoaiThuDao;
        public InsertAsyncTask(LoaiThuDao loaiThuDao) {
            this.mLoaiThuDao= loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mloaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<LoaiThu, Void, Void>{
        private LoaiThuDao mLoaiThuDao;
        public DeleteAsyncTask(LoaiThuDao loaiThuDao) {
            this.mLoaiThuDao= loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mloaiThuDao.delete(loaiThus[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<LoaiThu, Void, Void>{
        private LoaiThuDao mLoaiThuDao;
        public UpdateAsyncTask(LoaiThuDao loaiThuDao) {
            this.mLoaiThuDao= loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mloaiThuDao.update(loaiThus[0]);
            return null;
        }
    }
}
