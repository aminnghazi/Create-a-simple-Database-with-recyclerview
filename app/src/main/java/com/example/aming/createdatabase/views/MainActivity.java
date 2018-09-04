package com.example.aming.createdatabase.views;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aming.createdatabase.R;
import com.example.aming.createdatabase.model.Database.DatabaseHelper;
import com.example.aming.createdatabase.model.Database.Operator;
import com.example.aming.createdatabase.presenter.Mainpresenter;
import com.example.aming.createdatabase.views.adapters.RecyclerviewAdapter;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Ghazi Askar
    final static int REQUESTCODE_ADD = 120;
    Mainpresenter presenter;
    public RecyclerView recyclerView;
    FloatingActionButton fab;
    public static ArrayList<RecyclerviewItems> staticitemslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        recyclerView = findViewById(R.id.recyclerview);
       // recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        presenter = new Mainpresenter(this,this);
        presenter.initialload();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //insert data
            case R.id.fab:
                Intent i = new Intent(this,InsertActivity.class);
                startActivity(i);
           //     presenter.insert();
             //   boolean isinserted = Operator.insertdata(title.getText().toString(),content.getText().toString(),
                 //       createdate.getText().toString());
               // if(isinserted==true) Toast.makeText(this, "Data Inserted :D", Toast.LENGTH_SHORT).show();
               // else Toast.makeText(this, "Data Not Inserted :/ ", Toast.LENGTH_SHORT).show();
             //   presenter.transferDataToRecyclerview(false);
        }
    }


    public void launchitemslist(ArrayList<RecyclerviewItems> itemslist){
        RecyclerviewAdapter adapter=new RecyclerviewAdapter(this,itemslist);
        this.staticitemslist=itemslist;
        recyclerView.setAdapter(adapter);
    }

}
