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

import com.example.du_an_mau_lab.DAO.HDCTDao;
import com.example.du_an_mau_lab.DetailHDCTActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.model.HDCT;


import java.util.List;

import static com.example.du_an_mau_lab.model.ListHDCTActivity.lsHDCT;


public class HDCTAdapter extends BaseAdapter {
    private Context context;
    private List<HDCT> arrHDCT;
    private LayoutInflater inflater;
    private HDCTDao hdctDao;

    public HDCTAdapter(Context context, List<HDCT> arrHDCT) {
        this.context = context;
        this.arrHDCT = arrHDCT;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hdctDao = new HDCTDao(context);
    }

    @Override
    public int getCount() {
        return arrHDCT.size();
    }

    @Override
    public Object getItem(int position) {
        return arrHDCT.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HDCTAdapter.ViewHolder holder;
        if (convertView == null){
            //tao view
            holder= new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_hdct,null);
            holder.txtMaHoaDon = (TextView)convertView.findViewById(R.id.tv_MaHoaDon);
            holder.txtMaHDCT = (TextView)convertView.findViewById(R.id.tv_maHDCT);
            holder.btnDeleteHDCT = (Button)convertView.findViewById(R.id.btn_deleteHDCT);
            //xu li su kien delete
            holder.btnDeleteHDCT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HDCT hdct = arrHDCT.get(position);
                    arrHDCT.remove(hdct);//xoa tren list
                    notifyDataSetChanged();//update
                    hdctDao.deleteHDCT(String.valueOf(hdct.getMaHDCT()));//xoa trong database
                }
            });
            //tao template tu view
            convertView.setTag(holder);
        }else {
            //lay view da ton tai
            holder= (ViewHolder) convertView.getTag();
        }
        //lay du lieu
        HDCT hdct = (HDCT) arrHDCT.get(position);
        holder.txtMaHoaDon.setText(hdct.getMaHoaDon());
        holder.txtMaHDCT.setText(String.valueOf(hdct.getMaHDCT()));
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context, DetailHDCTActivity.class);
                Bundle b = new Bundle();
                b.putString("MaHoaDon",lsHDCT.get(position).getMaHoaDon());
                b.putString("MaHDCT", String.valueOf(lsHDCT.get(position).getMaHDCT()));
                b.putString("MaSP",lsHDCT.get(position).getMaSanPham());
                b.putString("SoLuong",lsHDCT.get(position).getSoLuong());
                intent.putExtras(b);
                context.startActivity(intent);
                return true;
            }
        });
        return convertView;
    }
    public static class ViewHolder{
        TextView txtMaHoaDon;
        TextView txtMaHDCT;
        Button btnDeleteHDCT;
    }
    public  void  changeDataset(List<HDCT> ls){
        this.arrHDCT = ls;
        notifyDataSetChanged();
    }
    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }
}
