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

import com.example.du_an_mau_lab.DAO.NguoiDungDao;
import com.example.du_an_mau_lab.DetailNguoiDungActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.model.NguoiDung;

import java.util.List;

import static com.example.du_an_mau_lab.model.ListNguoiDungActivity.lsND;

public class NguoiDungAdapter extends BaseAdapter {
private Context context;
private List<NguoiDung> arrNguoiDung;
private LayoutInflater inflater;
private NguoiDungDao nguoiDungDao;

    public NguoiDungAdapter(Context context, List<NguoiDung> arrNguoiDung) {
        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDao = new NguoiDungDao(context);
    }

    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //thiet lap view
    //lay du lieu
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            //taoview
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_user,null);
            holder.txtName =(TextView)convertView.findViewById(R.id.tvName);
            holder.txtPhone = (TextView)convertView.findViewById(R.id.tvPhone);

          holder.btnDelete = (Button)convertView.findViewById(R.id.btnDelete_user);

            //xu li su kien delete
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NguoiDung nd = arrNguoiDung.get(position);
                    arrNguoiDung.remove(nd);//chi xoa tren list,nhung chua xoa o database.vao nguoiDUngDao
                    notifyDataSetChanged();//update
                    nguoiDungDao.deleteUser(nd.getUsername());//delete in database
                }
            });

            //tao template tu view
            convertView.setTag(holder);

        }else {
            //lay view da ton tai
            holder=(ViewHolder)convertView.getTag();
        }
        //lay du lieu
        NguoiDung nguoiDung = (NguoiDung)arrNguoiDung.get(position);
        holder.txtName.setText(nguoiDung.getHoten());
        holder.txtPhone.setText(nguoiDung.getPhone());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent    intent = new Intent(context, DetailNguoiDungActivity.class);
                Bundle b = new Bundle();
                b.putString("username",lsND.get(position).getUsername());
                b.putString("password",lsND.get(position).getPassword());
                b.putString("phone",lsND.get(position).getPhone());
                b.putString("hoten",lsND.get(position).getHoten());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public static class ViewHolder{
        TextView txtName;
        TextView txtPhone;
        Button btnDelete;
    }

    public  void changeDataset(List<NguoiDung> ls){
        this.arrNguoiDung = ls;
        notifyDataSetChanged();
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
