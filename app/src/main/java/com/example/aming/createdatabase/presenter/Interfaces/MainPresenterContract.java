package com.example.aming.createdatabase.presenter.Interfaces;

import com.example.aming.createdatabase.model.items.RecyclerviewItems;

public interface MainPresenterContract {
    public void initialload();
    public void Additemresult   (int resultCode , RecyclerviewItems newItem);
}
