package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String Dbname="company.db";
    static String Tablename="Product";
    static String col1="productid";
    static String col2="productcode";
    static String col3="productname";
    static String col4="price";


    public DatabaseHelper( Context context )
    {
        super(context, Dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement,"+
                col2+" text,"+
                col3+" text,"+
                col4+" text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String productcode,String productname,String price){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,productcode);
        content.put(col3,productname);
        content.put(col4,price);
        long status=db.insert(Tablename,null,content);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor searchData(String prdcode){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+Tablename+" where "+col2+"='"+prdcode+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }
}
