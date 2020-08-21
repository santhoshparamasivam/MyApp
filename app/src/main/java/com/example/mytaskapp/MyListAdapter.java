package com.example.mytaskapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ImageView;  
import android.widget.RelativeLayout;  
import android.widget.TextView;  
import android.widget.Toast;

import com.example.mytaskapp.model.VechicleModel;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private ArrayList<VechicleModel> listdata;
  

    public MyListAdapter(ArrayList<VechicleModel>  listdata, Context context) {
        this.listdata = listdata;  
    }  
    @Override  
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {  
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());  
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);  
        return viewHolder;  
    }  
  
    @Override  
    public void onBindViewHolder(ViewHolder holder, int position) {  
//        final VechicleModel myListData = listdata[position];
        if (listdata.get(position).getVehicleName()!=null)
        holder.name.setText(listdata.get(position).getVehicleName());
        if (listdata.get(position).getTonnage()!=null)
        holder.tannage.setText(listdata.get(position).getTonnage());
        if (listdata.get(position).getVehicleModel()!=null)
        holder.vmodel.setText(listdata.get(position).getVehicleModel());
        if (listdata.get(position).getBodyType()!=null)
        holder.body_type.setText(listdata.get(position).getBodyType());
        if (listdata.get(position).getTruckAxleType()!=null)
        holder.axle_model.setText(listdata.get(position).getTruckAxleType());


    }  
  
  
    @Override  
    public int getItemCount() {  
        return listdata.size();
    }  
  
    public static class ViewHolder extends RecyclerView.ViewHolder {  

        public TextView name,tannage,vmodel,body_type,axle_model;
        public RelativeLayout relativeLayout;  
        public ViewHolder(View itemView) {  
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            tannage = (TextView) itemView.findViewById(R.id.tannage);
            vmodel = (TextView) itemView.findViewById(R.id.vmodel);
            body_type = (TextView) itemView.findViewById(R.id.body_type);
            axle_model = (TextView) itemView.findViewById(R.id.axle_model);

        }  
    }  
}  
