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

       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkthedata();

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    boolean isEmpty(EditText text) {
        CharSequence string = text.getText().toString();
        return TextUtils.isEmpty(string);
    }

    void checkthedata() {
        if (isEmpty(fname)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(lname)) {
            Toast t = Toast.makeText(this, "You must enter last name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(uname)) {
            uname.setError("You must enter username to register!");
        }

        if (isEmpty(pass)) {
            pass.setError("You must enter password to register!");
        }
        if (isEmpty(em)) {
            em.setError("You must enter email to register!");
        }

    }
}
