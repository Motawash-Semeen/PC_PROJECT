package com.jovanovic.stefan.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

    //MyDatabaseHelper myDB;
    dbhandler d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname =(EditText) findViewById(R.id.f1_name);
        lname =(EditText)  findViewById(R.id.l1_name);
        uname = (EditText) findViewById(R.id.u1_name);
        em =(EditText)  findViewById(R.id.e1_name);
        pass =(EditText)  findViewById(R.id.p1_name);
        b1 = (Button) findViewById(R.id.buu1);

        d1 = new dbhandler(this);

       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String f1=fname.getText().toString();
                String l1 =lname.getText().toString();
                String user =uname.getText().toString();
                String email =em.getText().toString();
                String passw =pass.getText().toString();
              if(f1.equals(""))
                {
                    Toast.makeText(Register.this, "You must enter first name to register!", Toast.LENGTH_SHORT).show();
                }
              else  if(l1.equals(""))
                {
                    Toast.makeText(Register.this, "You must enter last name to register!", Toast.LENGTH_SHORT).show();
                }
               else  if(user.equals(""))
                {
                    Toast.makeText(Register.this, "You must enter  user name to register!", Toast.LENGTH_SHORT).show();
                }
               else  if(email.equals(""))
                {
                    Toast.makeText(Register.this, "You must enter email to register!", Toast.LENGTH_SHORT).show();
                }
             else   if(passw.equals(""))
                {
                    Toast.makeText(Register.this, "You must enter password to register!", Toast.LENGTH_SHORT).show();
                }
           else
               {

                        Boolean insert=d1.insertuser(user,email,passw);
                        if(insert==true){
                            Toast.makeText(Register.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this,"Sorry,registration unsuccessful",Toast.LENGTH_SHORT).show();
                        }
              //    }


              }


          }
        });
    }
    boolean x=false;


    boolean isEmpty(EditText text) {
        CharSequence string = text.getText().toString();
        return TextUtils.isEmpty(string);
    }

}
