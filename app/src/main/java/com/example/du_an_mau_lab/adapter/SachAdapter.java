package com.example.du_an_mau_lab.adapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


import com.example.du_an_mau_lab.DAO.SachDao;
import com.example.du_an_mau_lab.DetailSachActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.model.Sach;

import java.util.List;

import static com.example.du_an_mau_lab.model.ListSachActivity.lsS;

public class SachAdapter extends BaseAdapter {
    private Context context;
    private List<Sach> arrSach;
    private LayoutInflater inflater;
    private SachDao sachDao;
    public SachAdapter(Context context, List<Sach> arrSach) {
        this.context = context;
        this.arrSach = arrSach;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sachDao = new SachDao(context);
    }
    @Override
    public int getCount() {
        return arrSach.size();
    }
    @Override
    public Sach  getItem(int position) {
        return arrSach.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            //tao view
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_sach, null);
            holder.txtTieuDe = (TextView) convertView.findViewById(R.id.tvTieuDe);
            holder.btnDeleteSach = (Button) convertView.findViewById(R.id.btnDeleteSach);
            //xu li su kien delete
            holder.btnDeleteSach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sach s = arrSach.get(position);
                    arrSach.remove(s);//xoa tren list
                    sachDao.deleteSach(s.getMaSach());//xoa trong database
                    //arrSach = sachDao.getAllSach();
                    notifyDataSetChanged();//update

                }
            });
            //tao template tu view
            convertView.setTag(holder);
        } else {
            //lay view da ton tai
            holder=(ViewHolder)convertView.getTag();
        }
        //lay du lieu
        Sach sach = (Sach)getItem(position);
        holder.txtTieuDe.setText(sach.getTieuDe());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailSachActivity.class);
                Bundle b = new Bundle();
                b.putString("maSach",lsS.get(position).getMaSach());
                b.putString("maTL",lsS.get(position).getMaTL());
                b.putString("tieuDe",lsS.get(position).getTieuDe());
                b.putString("soLuong", String.valueOf(lsS.get(position).getSoLuong()));
                b.putString("NXB",lsS.get(position).getNXB());
                b.putString("tacGia",lsS.get(position).getTacGia());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
        public void changeDataset(List<Sach> ls) {
            this.arrSach = ls;
            notifyDataSetChanged();
        }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public static class ViewHolder{
        TextView txtTieuDe;
        Button btnDeleteSach;
    }
}