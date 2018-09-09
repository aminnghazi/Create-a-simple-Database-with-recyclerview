package com.example.aming.createdatabase.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.aming.createdatabase.R;
import com.example.aming.createdatabase.views.interfaces.MainActivityContract;
import com.example.aming.createdatabase.presenter.Interfaces.MainPresenterContract;
import com.example.aming.createdatabase.presenter.Mainpresenter;
import com.example.aming.createdatabase.utils.Constants.Constants;
import com.example.aming.createdatabase.views.adapters.RecyclerviewAdapter;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainActivityContract {
    //Ghazi Askar
    MainPresenterContract presenter;
    public RecyclerView recyclerView;
    FloatingActionButton fab;
    RecyclerviewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        presenter = new Mainpresenter(this,this);
        presenter.initialload();
    }

    @Override
    public void applaunchItemslist(ArrayList<RecyclerviewItems> itemslist) {
        adapter=new RecyclerviewAdapter(this,itemslist);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //insert data
            case R.id.fab:
                Intent i = new Intent(this,InsertActivity.class);
                startActivityForResult(i, Constants.REQUEST_CODE_INSERT);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Constants.REQUEST_CODE_INSERT:
                RecyclerviewItems newitem=null;
                if(data != null){
                Bundle extras = data.getExtras();

                if(extras.size() >= 4){
                    long id = extras.getLong(Constants.EXTRAS_ID);
                    String createdate = extras.getString(Constants.EXTRAS_CREATEDATE);
                    String title = extras.getString(Constants.EXTRAS_TITLE);
                    String content = extras.getString(Constants.EXTRAS_CONTENT);
                    newitem = new RecyclerviewItems();
                    newitem.setId(id);
                    newitem.setCratedate(createdate);
                    newitem.setTitle(title);
                    newitem.setContent(content);
                }
                if(presenter!=null){
                    presenter.Additemresult(resultCode,newitem);
                }
        }
    }
    }

    @Override
    public void AddItem(RecyclerviewItems newItem) {
    if(adapter!=null){
        adapter.additem(newItem);
        Toast.makeText(this, "New Item Inserted(Recyclerview)", Toast.LENGTH_SHORT).show();
    }
    }

    @Override
    public void AddItemError() {
        Toast.makeText(this, "Item not added(Recyclerview)", Toast.LENGTH_SHORT).show();
    }
}
