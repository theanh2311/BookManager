package com.example.du_an_mau_lab.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.du_an_mau_lab.model.NguoiDung;
import com.example.du_an_mau_lab.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbhelper;
    public  static final String TAG = "TAG_NGUOIDUNG";
    public  static  final String TABLE_NAME = "NguoiDung";
    public static  final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (" +
            " username text primary key," +
            "password text," +
            "phone text," +
            "birthday text," +
            "hoten text );";
    public NguoiDungDao(Context context){
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public List<NguoiDung> getAllNguoiDung(){
        List<NguoiDung> lsND = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            NguoiDung nd = new NguoiDung();
            nd.setUsername(c.getString(0));
            nd.setPassword(c.getString(1));
            nd.setPhone(c.getString(2));
            nd.setBirthday(c.getString(3));
            nd.setHoten(c.getString(4));

            lsND.add(nd);
            c.moveToNext();
        }
        c.close();
        return lsND;
    }
    public  int insertNguoiDung(NguoiDung n){
        ContentValues values = new ContentValues();
        values.put("username",n.getUsername());
        values.put("password",n.getPassword());
        values.put("phone",n.getPhone());
        values.put("hoten",n.getHoten());
        values.put("birthday",n.getBirthday());
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

    public int updateUser(NguoiDung n){
        ContentValues values = new ContentValues();
        values.put("username",n.getUsername());
        values.put("password",n.getPassword());
        values.put("phone",n.getPhone());
        values.put("hoten",n.getHoten());
        values.put("birthday",n.getBirthday());
        int kq = db.update(TABLE_NAME, values,"username=?",new String[]{n.getUsername()});
        if (kq==0){
            return -1;
        }
        return 1;
    }

    public int deleteUser(String username){
        int kq = db.delete(TABLE_NAME,"username=?",new String[]{username});
        if (kq==0){
            return -1;//xoa khong thanh cong
        }
        return  1;//xoa thanh cong
    }
}
