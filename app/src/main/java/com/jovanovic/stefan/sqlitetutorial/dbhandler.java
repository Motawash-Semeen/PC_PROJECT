package com.jovanovic.stefan.sqlitetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbhandler extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "register.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME1 = "register";
    private static final String COLUMN_user = "Username";
    private static final String COLUMN_pass = "Password";
    private static final String COLUMN_email = "Email";


    public dbhandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db1) {
        String query2 = "CREATE TABLE " + TABLE_NAME1 +
                " (" + COLUMN_user + " TEXT, " +
                COLUMN_email + " TEXT, " +
                COLUMN_pass + " TEXT);";

        db1.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int i, int i1) {
        db1.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db1);
    }

    public boolean insertuser(String USER,String email,String pass){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_user,USER);
        contentValues.put(COLUMN_email,email);
        contentValues.put(COLUMN_pass,pass);
        long result = db1.insert(TABLE_NAME1,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkUSERNAME(String Username){

        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("select * from TABLE_NAME1 where Username= ?",new String[]{Username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkemail(String Email){

        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor = db1.rawQuery("select * from TABLE_NAME1 where Email= ?",new String[]{Email});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }


    public  Boolean findPassword(String name, String pass){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME1,null);
        Boolean result = false;

        if(cursor.getCount()==0){
            Toast.makeText(context, "No data is found", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                String username = cursor.getString(0);
                String password = cursor.getString(2);

                if(username.equals(name) && password.equals(pass)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


}
