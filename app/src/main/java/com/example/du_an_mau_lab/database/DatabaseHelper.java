package com.example.du_an_mau_lab.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.du_an_mau_lab.DAO.NguoiDungDao;
import com.example.du_an_mau_lab.DAO.SachDao;
import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.model.TheLoai;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="dbBM";
    public  static final int VERSION = 1;

    //tao db
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
//tao bang
    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(NguoiDungDao.SQL_NGUOI_DUNG);
         db.execSQL(TheLoaiDao.SQL_THE_LOAI);
        db.execSQL(SachDao.SQL_SACH);
    //    db.execSQL("");
    }
//upgrade bang
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ NguoiDungDao.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TheLoaiDao.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ SachDao.TABLE_NAME);
        db.execSQL("");
    }
}
