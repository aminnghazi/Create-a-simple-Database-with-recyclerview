package com.example.aming.createdatabase;

import android.database.Cursor;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aming.createdatabase.Database.DatabaseHelper;
import com.example.aming.createdatabase.Recycleview.RecyclerviewAdapter;
import com.example.aming.createdatabase.Recycleview.RecyclerviewItems;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Ghazi Askar
    Button btnAdd;
    DatabaseHelper DH;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<RecyclerviewItems> itemsList;
    EditText title;
    EditText content;
    EditText createdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DH = new DatabaseHelper(this);
        itemsList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        createdate = findViewById(R.id.createdate);
        btnAdd = findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this,itemsList);
        recyclerView.setAdapter(adapter);
        transferDataToRecyclerview(true);
    }
    //method baraye enteghale data az database be recycler view
    public void transferDataToRecyclerview(boolean isFromOnCreate){
        Cursor res = DH.getData();

        //agar Database khali bood payam midahad
        if(res.getCount()==0) {
            Toast.makeText(this, "Database Is Empty", Toast.LENGTH_LONG).show();

        //agar database khali nabood chizhaye daroone An ra be recyclerview enteghal midahad
        }else{
            if(isFromOnCreate==true){
            while (res.moveToNext()) {
                String id = res.getString(0);
                String title = res.getString(1);
                String content = res.getString(2);
                String createdate = res.getString(3);
                RecyclerviewItems item = new RecyclerviewItems(title, "ID = " + id, content,
                        "createdate = " + createdate);
                itemsList.add(item);
            }}
            else{
                res.moveToLast();
                    String id = res.getString(0);
                    String title = res.getString(1);
                    String content = res.getString(2);
                    String createdate = res.getString(3);
                    RecyclerviewItems item = new RecyclerviewItems(title, "ID = " + id, content,
                            "createdate = " + createdate);
                    itemsList.add(item);
                }

            }
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //insert data
            case R.id.btnadd:
                boolean isinserted = DH.insertdata(title.getText().toString(),content.getText().toString(),
                        createdate.getText().toString());
                if(isinserted==true) Toast.makeText(this, "Data Inserted :D", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Data Not Inserted :/ ", Toast.LENGTH_SHORT).show();
                transferDataToRecyclerview(false);
        }
    }
}
