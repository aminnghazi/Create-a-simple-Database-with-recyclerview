package com.example.aming.createdatabase.views.interfaces;

import com.example.aming.createdatabase.model.items.RecyclerviewItems;

public interface InsertActivityContract {
    public void AddItemFailed();
    public void AddItemSuccesfully();
    public void ItemInsertionCompleted(RecyclerviewItems item , int resultCode);
    public void InputsInvalid();
}
