package com.vikas.elibrary.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vikas.elibrary.info.Information;
import com.vikas.elibrary.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Dell on 12/17/2015.
 */
public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder> {

    private  LayoutInflater inflator;
    List<Information>  data= Collections.emptyList();
    private Context context;
    private ClickListener clickListener;

    public  VivzAdapter(Context context, List<Information>  data){
      inflator= LayoutInflater.from(context);
        this.data=data;
        this.context=context;
  }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflator.inflate(R.layout.custom_row_nav_draw,parent,false);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      Information current=data.get(position);
        holder.text.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setClickListener(VivzAdapter.ClickListener clickListener){

        this.clickListener=clickListener;
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.listMsg);
            icon=(ImageView)itemView.findViewById(R.id.listIcon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }
        }
    }
    public  interface ClickListener{
        public void itemClicked(View view,int position);
    }

}
