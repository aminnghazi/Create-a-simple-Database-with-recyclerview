package com.example.aming.createdatabase.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.aming.createdatabase.model.Database.Operator;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;
import com.example.aming.createdatabase.views.interfaces.MainActivityContract;
import com.example.aming.createdatabase.presenter.Interfaces.MainPresenterContract;
import com.example.aming.createdatabase.views.MainActivity;

import java.util.ArrayList;

public class Mainpresenter implements MainPresenterContract{
    Context context;
    MainActivityContract ma;
    public Mainpresenter(Context context,MainActivity ma) {
        this.context = context;
        this.ma=ma;
    }
    @Override
    public void initialload() {
    Operator op=new Operator(context);
        ArrayList<RecyclerviewItems> itemslist = op.getData();
        ma.applaunchItemslist(itemslist);
    }

    @Override
    public void Additemresult(int resultCode, RecyclerviewItems newItem) {
        if (resultCode == Activity.RESULT_OK)
            ma.AddItem(newItem);
        else
            ma.AddItemError();

    }
}


