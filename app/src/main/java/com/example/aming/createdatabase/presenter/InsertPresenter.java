package com.example.aming.createdatabase.presenter;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.aming.createdatabase.model.Database.DatabaseContract;
import com.example.aming.createdatabase.model.Database.Operator;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;
import com.example.aming.createdatabase.presenter.Interfaces.InsertActivityContract;
import com.example.aming.createdatabase.views.MainActivity;
import com.example.aming.createdatabase.views.adapters.RecyclerviewAdapter;

import java.util.ArrayList;

public class InsertPresenter implements InsertActivityContract {
    Context context;

    public InsertPresenter(Context context) {
        this.context = context;
    }

    @Override
    public boolean inserdata(String title, String content, String createDate) {
        if (title.trim().isEmpty() || content.trim().isEmpty() || createDate.trim().isEmpty()) {
            Toast.makeText(context, "Fill All Of The Inputs", Toast.LENGTH_SHORT).show();
            return false;
        }

        Operator op=new Operator(context);

        boolean ResultOfDatabase = op.insertdata(title,content,createDate);

        if (ResultOfDatabase==false){
          Toast.makeText(context, "Database Error", Toast.LENGTH_SHORT).show();
         return false;
        }
         RecyclerviewAdapter adapter=new RecyclerviewAdapter(context,MainActivity.staticitemslist);
        adapter.additem(op.getLastitem());
          return true;
        }
    }
