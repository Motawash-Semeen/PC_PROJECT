package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    MyDatabaseHelper databasehelper;
    Button login, register;
    TextView username, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);

        databasehelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databasehelper.getWritableDatabase();

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String name = username.getText().toString();
        String password = pass.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("username", name);
        bundle.putString("password", password);

        if(view.getId() == R.id.login){

            Boolean result = databasehelper.findPassword(name, password);
            if(result==true){
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Wrong Username or password", Toast.LENGTH_SHORT).show();
            }


        }
        if(view.getId() == R.id.register){
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        }
    }
}