package com.example.du_an_mau_lab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    private Context context;
    private List<TheLoai> arrTheLoai;
    private LayoutInflater inflater;
    private TheLoaiDao theLoaiDao;

    public TheLoaiAdapter(Context context, List<TheLoai> arrTheLoai) {
        this.context = context;
        this.arrTheLoai = arrTheLoai;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        theLoaiDao = new TheLoaiDao(context);
    }

    @Override
    public int getCount() {
        return arrTheLoai.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTheLoai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            //tao view
            holder= new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_theloai,null);
            holder.txtTenTL = (TextView)convertView.findViewById(R.id.tvTheLoai);
            holder.btnDeleteTL = (Button)convertView.findViewById(R.id.btn_sua_theLoai);
            holder.btnEditTL = (Button)convertView.findViewById(R.id.btn_xoa_theLoai);

        //xu li su kien delete
        holder.btnDeleteTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheLoai tl = arrTheLoai.get(position);
                arrTheLoai.remove(tl);//xoa tren list
                notifyDataSetChanged();//update
                theLoaiDao.deleteTL(tl.getMaTL());//xoa trong database
            }
        });

        //tao template tu view
        convertView.setTag(holder);

    }else {
        //lay view da ton tai
        holder= (ViewHolder)convertView.getTag();
    }
        //lay du lieu
        TheLoai theLoai = (TheLoai)arrTheLoai.get(position);
        holder.txtTenTL.setText(theLoai.getTenTL());
        return convertView;
    }
    public static class ViewHolder{
        TextView txtTenTL;
        Button btnDeleteTL;
        Button btnEditTL;
    }
}
