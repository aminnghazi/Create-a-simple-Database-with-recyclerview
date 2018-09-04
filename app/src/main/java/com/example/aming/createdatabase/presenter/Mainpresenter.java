package com.example.aming.createdatabase.presenter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aming.createdatabase.model.Database.DatabaseHelper;
import com.example.aming.createdatabase.model.Database.Operator;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;
import com.example.aming.createdatabase.presenter.Interfaces.MainPresenterContract;
import com.example.aming.createdatabase.views.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Mainpresenter implements MainPresenterContract{
    Context context;
    MainActivity ma;
    Operator op=new Operator(context);

    public Mainpresenter(Context context,MainActivity ma) {
        this.context = context;
        this.ma=ma;
    }
    @Override
    public void initialload() {
    Operator op=new Operator(context);
        ArrayList<RecyclerviewItems> itemslist = op.getData();
        ma.launchitemslist(itemslist);
    }

}


