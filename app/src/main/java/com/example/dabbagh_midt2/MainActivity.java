package com.example.dabbagh_midt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id, name, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseHelper database = new DatabaseHelper(this);
        Button add = (Button)findViewById(R.id.buttonADD);
        Button screen1to2 = (Button) findViewById(R.id.screen1to2);
        Button screen1to3 = (Button) findViewById(R.id.screen1to3);

        id = (EditText)findViewById(R.id.editTextCol1);
        name = (EditText)findViewById(R.id.editTextCol2);
        email = (EditText)findViewById(R.id.editTextCol3);
        phone = (EditText)findViewById(R.id.editTextCol4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(id.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter an ID ", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(name.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter a name ", Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter an email ", Toast.LENGTH_LONG).show();
                }
                else {
                    int id_val = Integer.parseInt(id.getText().toString());
                    String name_val = name.getText().toString();
                    String email_val = email.getText().toString();
                    int phone_val;
                    if (TextUtils.isEmpty(phone.getText().toString())){
                        phone_val = 0;
                    }
                    else{
                        phone_val = Integer.parseInt(phone.getText().toString());
                    }
                    try {
                        database.addStudent(id_val, name_val, phone_val, email_val);
                        Log.d("Yasmeen", "Add Success");
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Add Fail", Toast.LENGTH_SHORT).show();
                        Log.d("Yasmeen", "Add FAIL");
                    }
                }
            }
        });
        screen1to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
        screen1to3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });
    }
}