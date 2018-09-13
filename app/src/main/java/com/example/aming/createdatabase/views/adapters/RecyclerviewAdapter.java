package com.example.aming.createdatabase.views.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aming.createdatabase.R;

import com.example.aming.createdatabase.model.Database.DatabaseHelper;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;
import com.example.aming.createdatabase.views.interfaces.ItemsManagement;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends Adapter<RecyclerviewAdapter.MyViewholder>{
    Context context;
    ArrayList<RecyclerviewItems> itemslist;
    ItemsManagement im;

    public void setItemsManagement(ItemsManagement im) {
        this.im = im;
    }

    public RecyclerviewAdapter(Context context, ArrayList<RecyclerviewItems> itemslist) {
        this.context = context;
        this.itemslist = itemslist;
    }

    public class MyViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView id;
        TextView content;
        TextView title;
        TextView createdate;
        ImageButton btnedit;
        RecyclerviewItems selecteditem;

        public MyViewholder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            content = itemView.findViewById(R.id.content);
            title = itemView.findViewById(R.id.title);
            createdate = itemView.findViewById(R.id.createdate);
            btnedit = itemView.findViewById(R.id.editbtn);
            btnedit.setOnClickListener(this);
            //cardView = itemView.findViewById(R.id.cardview);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.editbtn:
                    PopupMenu popup=new PopupMenu(context,btnedit);
                    popup.inflate(R.menu.editpopup_menu);
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.del_item:
                                    int index = getAdapterPosition();
                                    selecteditem = itemslist.get(index);
                                    im.itemDeletSelected(selecteditem);

                            default :
                                return false;
                            }
                        }
                    });
                    popup.show();
            }
        }
    }


    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(context);
       View v = inflater.inflate(R.layout.recyclerviewitem,null,false);
       //View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent,false);
       return new MyViewholder(v);
    }


    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
    RecyclerviewItems item=itemslist.get(position);
    if(item!=null) {
        holder.title.setText(item.getTitle());
        holder.createdate.setText(item.getCratedate());
        holder.id.setText("ID = " + item.getId().toString());
        holder.content.setText(item.getContent());
    }
    }


    public void additem(RecyclerviewItems item) {
        itemslist.add(item);
        int pos = itemslist.lastIndexOf(item);
        notifyItemInserted(pos);
    }
    public void deletitem(RecyclerviewItems item){
        int position = itemslist.indexOf(item);
        itemslist.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return itemslist.size();
    }
}
