package com.jovanovic.stefan.sqlitetutorial;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText fname;
    EditText lname;
    EditText uname;
    EditText em;
    EditText pass;
    Button b1;

    MyDatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname = findViewById(R.id.f1_name);
        lname = findViewById(R.id.l1_name);
        uname = findViewById(R.id.u1_name);
        em = findViewById(R.id.e1_name);
        pass = findViewById(R.id.p1_name);
        b1 = findViewById(R.id.buu1);

        myDB = new MyDatabaseHelper(Register.this);

       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkthedata();


               if(x==false){

                   String user =uname.getText().toString();
                   String email =em.getText().toString();
                   String passw =pass.getText().toString();
                   Boolean cu=myDB.checkUSERNAME(user);
                   Boolean em1=myDB.checkemail(email);
                   if(cu==true) Toast.makeText(Register.this,"Username already exists",Toast.LENGTH_SHORT).show();
                   else if(em1==true) Toast.makeText(Register.this,"Email already exists",Toast.LENGTH_SHORT).show();
                    else  {
                        Boolean insert=myDB.insertuser(user,email,passw);
                        if(insert==true){
                            Toast.makeText(Register.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this,"Sorry,registration unsuccessful",Toast.LENGTH_SHORT).show();
                        }

                   }


              }


            }
        });
    }
    boolean x=false;


    boolean isEmpty(EditText text) {
        CharSequence string = text.getText().toString();
        return TextUtils.isEmpty(string);
    }

    void checkthedata() {
        if (isEmpty(fname)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
            x=true;
        }

        if (isEmpty(lname)) {
            Toast t = Toast.makeText(this, "You must enter last name to register!", Toast.LENGTH_SHORT);
            t.show();
            x=true;
        }

        if (isEmpty(uname)) {
            uname.setError("You must enter username to register!");
            x=true;
        }

        if (isEmpty(pass)) {
            pass.setError("You must enter password to register!");
            x=true;
        }
        if (isEmpty(em)) {
            em.setError("You must enter email to register!");
            x=true;
        }


    }
}
