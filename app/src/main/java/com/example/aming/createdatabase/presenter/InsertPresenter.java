package com.example.aming.createdatabase.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.aming.createdatabase.model.Database.Operator;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;
import com.example.aming.createdatabase.views.interfaces.InsertActivityContract;
import com.example.aming.createdatabase.presenter.Interfaces.InsertPresenterContract;
import com.example.aming.createdatabase.views.InsertActivity;

public class InsertPresenter implements InsertPresenterContract {
    Context context;
    InsertActivityContract view;
    Operator op;

    public InsertPresenter(Context context ,InsertActivityContract view ) {
        this.context = context;
        this.view=view;
        op=new Operator(context);
    }

    @Override
    public void insertdata(String title, String content, String createDate) {
            if (title.trim().isEmpty() || content.trim().isEmpty() || createDate.trim().isEmpty()) {
                if(view!=null) {
                    view.InputsInvalid();
                }
                return;
            }


        RecyclerviewItems item=new RecyclerviewItems();
        item.setContent(content);
        item.setTitle(title);
        item.setCratedate(createDate);

         RecyclerviewItems ResultOfDatabase = op.insertdata(item);


        if (ResultOfDatabase==null){
            view.AddItemFailed();
            view.ItemInsertionCompleted(null ,Activity.RESULT_CANCELED);
         return ;
        }

        else
            if(view!=null) {

                view.AddItemSuccesfully();
                view.ItemInsertionCompleted(item, Activity.RESULT_OK);
                return;
            }
    }}
