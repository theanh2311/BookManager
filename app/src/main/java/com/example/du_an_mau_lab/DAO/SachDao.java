package com.example.du_an_mau_lab.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.du_an_mau_lab.database.DatabaseHelper;
import com.example.du_an_mau_lab.model.Sach;

import java.util.ArrayList;
import java.util.List;


public class SachDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbhelper;
    public  static final String TAG = "TAG_SACH";
    public  static  final String TABLE_NAME = "Sach";
    public static  final String SQL_SACH = "CREATE TABLE Sach (" +
            " maSach text primary key," +
            " maTL text," +
            "tieuDe text," +
            "tacGia text," +
            "soLuong int," +
            "NXB text );";
    public SachDao(Context context){
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }
    public List<Sach> getAllSach(){
        List<Sach> lsS = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        Log.e("Count", String.valueOf(c.getCount()));
        while (c.isAfterLast()==false){
            Sach s = new Sach();
            s.setMaSach(c.getString(0));
            s.setMaTL(c.getString(1));
            s.setTieuDe(c.getString(2));
            s.setTacGia(c.getString(3));
            s.setSoLuong(Integer.parseInt(c.getString(4)));
            s.setNXB(c.getString(5));
            lsS.add(s);
            c.moveToNext();
        }
        c.close();
        return lsS;
    }
    public  int insertSach(Sach s){
        ContentValues values = new ContentValues();
        values.put("maSach",s.getMaSach());
        values.put("maTL",s.getMaTL());
        values.put("tieuDe",s.getTieuDe());
        values.put("soLuong",s.getSoLuong());
        values.put("NXB",s.getNXB());
        values.put("tacGia",s.getTacGia());
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
    public  int updateSach(Sach s){
        ContentValues values = new ContentValues();
        values.put("maSach",s.getMaSach());
        values.put("maTL",s.getMaTL());
        values.put("tieuDe",s.getTieuDe());
        values.put("tacGia",s.getTacGia());
        values.put("soLuong",s.getSoLuong());
        values.put("NXB",s.getNXB());
        int kq = db.update(TABLE_NAME,values,"maSach=?",new String[]{s.getMaSach()});
        if (kq==0){
            return  -1;
        }
        return 1;
    }
    public int deleteSach(String maSach){
        int kq = db.delete(TABLE_NAME,"maSach=?",new String[]{maSach});
        if (kq==0){
            return -1;//xoa khong thanh cong
        }
        return  1;//xoa thanh cong
    }

}
