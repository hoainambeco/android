package com.example.asm.dao;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.asm.entity.LoaiThu;
import com.example.asm.entity.Thu;

import org.jetbrains.annotations.NotNull;

@Database(entities = {LoaiThu.class, Thu.class},version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LoaiThuDao loaiThuDao();
    public abstract ThuDao thuDao();

    public static AppDatabase INSTANCE;
    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateData(INSTANCE).execute();
        }
    };
    public static AppDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"personal_db").fallbackToDestructiveMigration().addCallback(callback).build();
            }
        }
        return INSTANCE;
    }
    public static class PopulateData extends AsyncTask<Void , Void,Void>{
        private LoaiThuDao loaiThuDao;
        private ThuDao thuDao;

        public PopulateData(AppDatabase db){
            loaiThuDao =db.loaiThuDao();
            thuDao = db.thuDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loạiThus = new String[]{"Lương","Thưởng","Bán Config"};
            for (String it : loạiThus){
                LoaiThu loaiThu = new LoaiThu();
                loaiThu.ten = it;
                loaiThuDao.insert(loaiThu);
            }
            Thu thu = new Thu();
            thu.ten = "lương tháng 1";
            thu.sotien = 3000000;
            thu.ltid = 2;
            thu.ghichu="";
            thuDao.insert(thu);
            Log.d("BudgetPro: ","insert data");
            return null;
        }
    }
}
