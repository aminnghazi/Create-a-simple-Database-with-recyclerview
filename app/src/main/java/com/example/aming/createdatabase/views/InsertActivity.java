package com.example.aming.createdatabase.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aming.createdatabase.R;
import com.example.aming.createdatabase.presenter.InsertPresenter;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {
    InsertPresenter presenter;
    EditText title;
    EditText content;
    EditText createdate;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        createdate = findViewById(R.id.createdate);
        btnAdd = findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnadd:
                presenter = new InsertPresenter(this);
                boolean result = presenter.inserdata(title.getText().toString() ,
                        content.getText().toString() , createdate.getText().toString());
                if (result==false)
                    break;
                if (result==true){
                    Toast.makeText(this, "Data Added Succesfully", Toast.LENGTH_SHORT).show();
                    break;
                }

        }
    }
}
