package com.example.aming.createdatabase.Recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.aming.createdatabase.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewholder>{
    Context context;
    List<RecyclerviewItems> itemslist;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<RecyclerviewItems> getItemslist() {
        return itemslist;
    }

    public void setItemslist(List<RecyclerviewItems> itemslist) {
        this.itemslist = itemslist;
    }

    public RecyclerviewAdapter(Context context, List<RecyclerviewItems> itemslist) {
        this.context = context;
        this.itemslist = itemslist;
    }
// sakhte classe viewholder
    public class MyViewholder extends RecyclerView.ViewHolder{
        TextView id;
        TextView content;
        TextView title;
        TextView createdate;
        public MyViewholder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            content = itemView.findViewById(R.id.content);
            title = itemView.findViewById(R.id.title);
            createdate = itemView.findViewById(R.id.createdate);
        }
    }
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent,false);
       return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
    RecyclerviewItems item=itemslist.get(position);
    holder.title.setText(item.getContent());
    holder.createdate.setText(item.getCratedate());
    holder.id.setText(item.getId().toString());
    holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemslist.size();
    }
}
