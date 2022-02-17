package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchproductActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    AppCompatButton b1,b2;
    String getPrdCode,getPrdName,getPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchproduct);
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
                Toast.makeText(getApplicationContext(), getPrdCode,Toast.LENGTH_LONG).show();

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