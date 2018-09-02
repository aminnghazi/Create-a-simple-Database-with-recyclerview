package com.example.aming.createdatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aming.createdatabase.Database.DatabaseHelper;
import com.example.aming.createdatabase.Recycleview.RecyclerviewItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
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
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        createdate = findViewById(R.id.createdate);
    }
    public void transferDataToRecyclerview(){
        Cursor res = DH.getData();
        if(res.getCount()==0) {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }else{
            itemsList = new ArrayList<>();
            String id = res.getString(0);
            String title = res.getString(1);
            String content = res.getString(2);
            String createdate = res.getString(3);
            RecyclerviewItems item = new RecyclerviewItems(title,id,content,createdate);

        }

    }
}
