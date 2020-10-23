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

import com.example.du_an_mau_lab.DAO.HoaDonDao;

import com.example.du_an_mau_lab.DetailHoaDonActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.model.HoaDon;


import java.util.List;

import static com.example.du_an_mau_lab.model.ListHoaDonActivity.lsHD;


public class HoaDonAdapter extends BaseAdapter {
    private Context context;
    private List<HoaDon> arrHoaDon;
    private LayoutInflater inflater;
    private HoaDonDao hoaDonDao;

    public HoaDonAdapter(Context context, List<HoaDon> arrHoaDon) {
        this.context = context;
        this.arrHoaDon = arrHoaDon;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hoaDonDao = new HoaDonDao(context);
    }

    public HoaDonAdapter() {

    }

    @Override
    public int getCount() {
        return arrHoaDon.size();
    }

    @Override
    public Object getItem(int position) {
        return arrHoaDon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null){
            //tao view
            holder= new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_hoa_don,null);
            holder.txtMaHoaDon = (TextView)convertView.findViewById(R.id.tv_MaHoaDon);
            holder.txtNgayMua = (TextView)convertView.findViewById(R.id.tv_NgayMua);
            holder.btnDeleteHoaDon = (Button)convertView.findViewById(R.id.btn_deleteHoaDon);
            //xu li su kien delete
            holder.btnDeleteHoaDon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HoaDon hd = arrHoaDon.get(position);
                    arrHoaDon.remove(hd);//xoa tren list
                    notifyDataSetChanged();//update
                    hoaDonDao.deleteHD(hd.getMaHoaDon());//xoa trong database
                }
            });


            //tao template tu view
            convertView.setTag(holder);
        }else {
            //lay view da ton tai
            holder= (ViewHolder)convertView.getTag();
        }
        //lay du lieu
        HoaDon hoaDon = (HoaDon)arrHoaDon.get(position);
        holder.txtMaHoaDon.setText(hoaDon.getMaHoaDon());
        holder.txtNgayMua.setText(hoaDon.getNgayMua());
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, DetailHoaDonActivity.class);
                Bundle b = new Bundle();
                b.putString("MaHoaDon",lsHD.get(position).getMaHoaDon());
                b.putString("NgayMua",lsHD.get(position).getNgayMua());
                intent.putExtras(b);
                context.startActivity(intent);
                return true;
            }
        });
        return convertView;
    }
    public static class ViewHolder{
        TextView txtMaHoaDon;
        TextView txtNgayMua;
        Button btnDeleteHoaDon;
    }
    public  void  changeDataset(List<HoaDon> ls){
        this.arrHoaDon = ls;
        notifyDataSetChanged();
    }
    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }
    }

