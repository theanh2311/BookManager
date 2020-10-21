package com.example.du_an_mau_lab.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.du_an_mau_lab.database.DatabaseHelper;
import com.example.du_an_mau_lab.model.HDCT;
import com.example.du_an_mau_lab.model.HoaDon;
import com.example.du_an_mau_lab.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class HDCTDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbhelper;
    public  static final String TAG = "TAG_HDCT";
    public  static  final String TABLE_NAME = "HDCT";
    public static  final String SQL_HDCT = "CREATE TABLE HDCT (" +
            " maHDCT integer primary key autoincrement," +
            "maHoaDOn text,"+
            "maSanPham text,"+
            "soLuong text );";
    public HDCTDao(Context context){
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public List<HDCT> getAllHDCT(){
        List<HDCT> lsHDCT = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            HDCT hdct = new HDCT();
            hdct.setMaHDCT(c.getString(0));
            hdct.setMaHoaDon(c.getString(1));
            hdct.setMaSanPham(c.getString(2));
            hdct.setSoLuong(c.getString(3));
            lsHDCT.add(hdct);
            c.moveToNext();
        }
        c.close();
        return lsHDCT;
    }
    public  int insertHDCT(HDCT hdct){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",hdct.getMaHoaDon());
        values.put("maHDCT",hdct.getMaHDCT());
        values.put("soLuong",hdct.getSoLuong());
        values.put("maSanPham",hdct.getMaSanPham());
        try{
            //excute insert
            if(db.insert(TABLE_NAME,null,values)<0){
                return -1;
            }
        }catch (Exception e){
            Log.e(TAG,e.toString());
        }
        return 1;
    }

    public  int updateHDCT(HDCT hdct){
        ContentValues values = new ContentValues();
        values.put("maHDCT",hdct.getMaHDCT());
        values.put("maHoaDon", hdct.getMaHoaDon());
        values.put("maSanPham", hdct.getMaSanPham());
        values.put("soLuong", hdct.getSoLuong());
        int kq = db.update(TABLE_NAME,values,"maHDCT=?",new String[]{hdct.getMaHDCT()});
        if (kq==0){
            return  -1;
        }
        return 1;
    }
    public int deleteHDCT(String maHDCT){
        int kq = db.delete(TABLE_NAME,"maHDCT=?",new String[]{maHDCT});
        if (kq==0){
            return -1;//xoa khong thanh cong
        }
        return  1;//xoa thanh cong
    }
}
