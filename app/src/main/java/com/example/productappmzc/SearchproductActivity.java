package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchproductActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    AppCompatButton b1,b2;
    String getPrdCode,getPrdName,getPrice;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchproduct);
        helper=new DatabaseHelper(this);
        helper.getWritableDatabase();
        e1=(EditText)findViewById(R.id.prdcode);
        e2=(EditText)findViewById(R.id.prdname);
        e3=(EditText)findViewById(R.id.price);
        b1=(AppCompatButton)findViewById(R.id.search);
        b2=(AppCompatButton)findViewById(R.id.backtomenu);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrdCode=e1.getText().toString();
                getPrdName=e2.getText().toString();
                getPrice=e3.getText().toString();
                Cursor c=helper.searchData(getPrdCode);
                if(c.getCount()==0){
                    e2.setText("");
                    e3.setText("");
                    Toast.makeText(getApplicationContext(), "invalid product code",Toast.LENGTH_LONG).show();
                }
                else{
                    while (c.moveToNext()){
                        getPrdName=c.getString(2);
                        getPrice=c.getString(3);
                    }
                    e2.setText(getPrdName);
                    e3.setText(getPrice);
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}