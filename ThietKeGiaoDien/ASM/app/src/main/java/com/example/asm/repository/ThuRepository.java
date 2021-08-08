package com.example.asm.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.asm.dao.AppDatabase;
import com.example.asm.dao.ThuDao;
import com.example.asm.entity.Thu;
import com.example.asm.entity.Thu;

import java.util.List;

public class ThuRepository {
    private ThuDao mthuDao;
    private LiveData<List<Thu>> mAllThu;

    public ThuRepository(Application application) {
        this.mthuDao = AppDatabase.getDatabase(application).thuDao();
        mAllThu = mthuDao.findAll();
    }

    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }
    public LiveData<Integer> sumTongThu() {
        return mthuDao.sumTongThu();
    }

    public void insert(Thu thu){
        new InsertAsyncTask(mthuDao).execute(thu);
    }
    public void delete(Thu thu){
        new DeleteAsyncTask(mthuDao).execute(thu);
    }
    public void update(Thu thu){
        new UpdateAsyncTask(mthuDao).execute(thu);
    }

    class InsertAsyncTask extends AsyncTask<Thu, Void, Void>{
        private ThuDao mThuDao;
        public InsertAsyncTask(ThuDao thuDao) {
            this.mThuDao= thuDao;
        }

        @Override
        protected Void doInBackground(Thu... thus) {
            mthuDao.insert(thus[0]);
            return null;
        }
    }
    class DeleteAsyncTask extends AsyncTask<Thu, Void, Void>{
        private ThuDao mThuDao;
        public DeleteAsyncTask(ThuDao thuDao) {
            this.mThuDao= thuDao;
        }

        @Override
        protected Void doInBackground(Thu... thus) {
            mthuDao.delete(thus[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<Thu, Void, Void>{
        private ThuDao mThuDao;
        public UpdateAsyncTask(ThuDao thuDao) {
            this.mThuDao= thuDao;
        }

        @Override
        protected Void doInBackground(Thu... thus) {
            mthuDao.update(thus[0]);
            return null;
        }
    }
}
