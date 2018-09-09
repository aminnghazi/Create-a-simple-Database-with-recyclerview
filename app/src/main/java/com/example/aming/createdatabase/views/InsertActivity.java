package com.example.aming.createdatabase.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aming.createdatabase.R;
import com.example.aming.createdatabase.model.items.RecyclerviewItems;
import com.example.aming.createdatabase.presenter.InsertPresenter;
import com.example.aming.createdatabase.views.interfaces.InsertActivityContract;
import com.example.aming.createdatabase.presenter.Interfaces.InsertPresenterContract;
import com.example.aming.createdatabase.utils.Constants.Constants;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener,InsertActivityContract {
    InsertPresenterContract presenter;

    EditText title;
    EditText content;
    EditText createdate;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter =new InsertPresenter(this,this);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        createdate = findViewById(R.id.createdate);
        btnAdd = findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnadd:
                if (presenter != null) {
                    presenter.insertdata(title.getText().toString(),
                            content.getText().toString(), createdate.getText().toString());
                }
        }
    }


    @Override
    public void AddItemFailed() {
        Toast.makeText(this, "Data Add Failed(database)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddItemSuccesfully() {
        Toast.makeText(this, "Data Added Succesfully(Database)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ItemInsertionCompleted(RecyclerviewItems item, int resultCode) {
        if(item==null){
            setResult(RESULT_CANCELED);
        }
        else {
            Intent data=new Intent();
            data.putExtra(Constants.EXTRAS_CONTENT,item.getContent());
            data.putExtra(Constants.EXTRAS_CREATEDATE , item.getCratedate());
            data.putExtra(Constants.EXTRAS_ID , item.getId());
            data.putExtra(Constants.EXTRAS_TITLE , item.getTitle());
            setResult(RESULT_OK , data);
        }
        finish();
    }

    @Override
    public void InputsInvalid() {
        Toast.makeText(this, "Inputs Are NOT Valid", Toast.LENGTH_SHORT).show();
    }
}
