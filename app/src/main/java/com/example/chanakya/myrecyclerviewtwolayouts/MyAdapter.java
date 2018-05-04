package com.example.chanakya.myrecyclerviewtwolayouts;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chanakya on 5/4/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Object> list1;

    public MyAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list1 = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(context);

        switch(viewType){
            case 1:
                View v1 = inflater.inflate(R.layout.item1, parent, false);
                viewHolder = new MyViewHolder(v1);
                break;
            case 0:
                View v2 = inflater.inflate(R.layout.item2, parent, false);
                viewHolder = new MyViewHolder2(v2);
                break;

            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new RecyclerViewSimpleTextViewHolder(v);
                break;

        }

          return viewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        switch (holder.getItemViewType()) {

            case 1:
                MyViewHolder vh1 = (MyViewHolder) holder;
                configureViewHolder(vh1, position);
                break;

            case 0:
                MyViewHolder2 vh2 = (MyViewHolder2) holder;
                configureViewHolder2(vh2, position);
                break;

            default:
                RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) holder;
                configureDefaultViewHolder(vh, position);
                break;

        }

    }

    private void configureDefaultViewHolder(RecyclerViewSimpleTextViewHolder vh, int position) {
    }

    private void configureViewHolder2(MyViewHolder2 vh2, int position) {

        vh2.getImage().setImageResource(R.drawable.ic_action_name);
    }

    private void configureViewHolder(MyViewHolder vh1, int position) {
        Item1 item =  (Item1) list1.get(position);
        if (item != null) {
            vh1.getTv1().setText("Title1" + item.title1);
            vh1.getTv2().setText("Title 2" + item.title2);
        }
    }


    @Override
    public int getItemCount() {
        return list1.size();
    }

    @Override
    public int getItemViewType(int position) {


       if( list1.get(position) instanceof Item1){
           return 1;
       }
       else if(list1.get(position) instanceof String){
           return 0;
       }

       return -1;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv1,tv2;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.tv1 = itemView.findViewById(R.id.textView);
            this.tv2 = itemView.findViewById(R.id.textView2);
        }

        public TextView getTv1() {
            return tv1;
        }

        public void setTv1(TextView tv1) {
            this.tv1 = tv1;
        }

        public TextView getTv2() {
            return tv2;
        }

        public void setTv2(TextView tv2) {
            this.tv2 = tv2;
        }
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder{

        ImageView image;

        public MyViewHolder2(View itemView) {
            super(itemView);

            this.image = itemView.findViewById(R.id.imageView);

        }

        public ImageView getImage() {
            return image;
        }

        public void setImage(ImageView image) {
            this.image = image;
        }
    }


    public class RecyclerViewSimpleTextViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public RecyclerViewSimpleTextViewHolder(View v) {
            super(v);

            this.tv = v.findViewById(R.id.textView3);
        }

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }
    }



}
