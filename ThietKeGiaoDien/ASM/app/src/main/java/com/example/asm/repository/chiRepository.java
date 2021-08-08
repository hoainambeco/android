package com.example.asm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.asm.dao.AppDatabase;
import com.example.asm.dao.ChiDao;
import com.example.asm.dao.ThuDao;
import com.example.asm.entity.Chi;
import com.example.asm.entity.Thu;

import java.util.List;

public class chiRepository {
    private ChiDao mchiDao;
    private LiveData<List<Chi>> mAllThu;

    public chiRepository(Application application) {
        this.mchiDao = AppDatabase.getDatabase(application).chiDao();
        mAllThu = mchiDao.findAll();
    }

    public LiveData<List<Chi>> getAllChi() {
        return mAllThu;
    }
    public LiveData<Integer> sumTongChi() {
        return mchiDao.sumTongChi();
    }

    public void insert(Chi chi){
        new InsertAsyncTask(mchiDao).execute(chi);
    }
    public void delete(Chi chi){
        new DeleteAsyncTask(mchiDao).execute(chi);
    }
    public void update(Chi chi){
        new UpdateAsyncTask(mchiDao).execute(chi);
    }

    class InsertAsyncTask extends AsyncTask<Chi, Void, Void>{
        private ChiDao mThuDao;
        public InsertAsyncTask(ChiDao thuDao) {
            this.mThuDao= thuDao;
        }

        @Override
        protected Void doInBackground(Chi... thus) {
            mchiDao.insert(thus[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<Chi, Void, Void>{
        private ChiDao mThuDao;
        public DeleteAsyncTask(ChiDao thuDao) {
            this.mThuDao= thuDao;
        }

        @Override
        protected Void doInBackground(Chi... thus) {
            mchiDao.delete(thus[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<Chi, Void, Void>{
        private ChiDao mThuDao;
        public UpdateAsyncTask(ChiDao thuDao) {
            this.mThuDao= thuDao;
        }

        @Override
        protected Void doInBackground(Chi... thus) {
            mchiDao.update(thus[0]);
            return null;
        }
    }
}
