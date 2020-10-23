package com.example.du_an_mau_lab.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.du_an_mau_lab.database.DatabaseHelper;
import com.example.du_an_mau_lab.model.HoaDon;
import com.example.du_an_mau_lab.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbhelper;
    public  static final String TAG = "TAG_HOADON";
    public  static  final String TABLE_NAME = "HoaDon";
    public static  final String SQL_HOA_DON = "CREATE TABLE HoaDon (" +
            " maHoaDon text primary key," +
            "ngayMua text );";
    public HoaDonDao(Context context){
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> lsHD = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            HoaDon hd = new HoaDon();
            hd.setMaHoaDon(c.getString(0));
            hd.setNgayMua(c.getString(1));
            lsHD.add(hd);
            c.moveToNext();
        }
        c.close();
        return lsHD;
    }
    public  int insertHoaDon(HoaDon h){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",h.getMaHoaDon());
        values.put("ngayMua",h.getNgayMua());
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

    public  int updateHD(HoaDon h){
        ContentValues values = new ContentValues();
        values.put("maHoaDon",h.getMaHoaDon());
        values.put("ngayMua",h.getNgayMua());
        int kq = db.update(TABLE_NAME,values,"maHoaDon=?",new String[]{h.getMaHoaDon()});
        if (kq==0){
            return  -1;
        }
        return 1;
    }
    public int deleteHD(String maHoaDon){
        int kq = db.delete(TABLE_NAME,"maHoaDon=?",new String[]{maHoaDon});
        if (kq==0){
            return -1;//xoa khong thanh cong
        }
        return  1;//xoa thanh cong
    }

}
